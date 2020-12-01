# Load Balancer

The Ingress Load Balancer gives internet access to your environment's services via proxied HTTP(S) connections using TLS (1.0 to 1.2) protocol. Each load balancer has a static IP that can use to set up custom domains.

![You can configure your environment's load balancer with a custom domain.](./load-balancer/images/01.png)

Having a dedicated load balancer provides a myriad of enhanced features, such as port configuration, custom SSL certificates, and a CDN. These features can be configured in a service's `LCP.json` file:

```json
{
  "id": "webserver",
  "loadBalancer": {
    "cdn": true,
    "targetPort": 80,
    "customDomains": ["acme.liferay.cloud"],
    "ssl": {
      "key": "...",
      "crt": "..."
    }
  }
}
```

## CDN

Liferay's Content Delivery Network (CDN) is a built-in feature provided with DXP Cloud. This CDN caches your content globally, greatly enhancing your delivery speed. This CDN is disabled by default but you can turn it on in your `LCP.json`:

```json
"cdn": true
```

![The CDN's status is visible on the Network page.](./load-balancer/images/02.png)

## Port

You can set which internal port (`targetPort`) the load balancer's service endpoint routes to. DXP Cloud automatically configures the correct port for the services it provides.

```json
"targetPort": 3000
```

![The load balancer shows your port configurations.](./load-balancer/images/03.png)

## Custom SSL

When you specify the load balancer attribute for a service, it adds a service endpoint using the following naming pattern:

- `<SERVICE-NAME>-<PROJECT-NAME>-<ENVIRONMENT-NAME>.lfr.cloud`

Domains created by DXP Cloud's infrastructure at `.lfr.cloud` are covered by a wildcard certificate that is not displayed in the Network page's SSL certificates section.

For all custom domains added through the console or `LCP.json`, Liferay DXP Cloud reaches out to [Let's Encrypt](https://letsencrypt.org/) for a certificate that renews automatically and covers all custom domains you create.

### Custom SSL Certificates

You can also add your own SSL certificate to cover any custom domains you create. However, only one certificate can be used at a time for a service's custom domains: either the one provided by Let's Encrypt, or the custom one specified in its `LCP.json`. If both certificates exist, the custom certificate takes precedent.

When creating custom certificates, note that DXP Cloud only accepts keys and certificates that are in the proper PEM format with [Base64](https://tools.ietf.org/html/rfc4648#section-4) encoding, which must include encapsulation boundaries:

```json
"ssl": {
  "key": "...",
  "crt": "..."
}
```

```important::
   The ``ssl`` property (containing the ``key`` and ``crt`` properties) must be contained within the ``loadbalancer`` property to work properly.
```

When generating a key, you must use either RSA-2048 or ECDSA P-256 encryption algorithms and avoid using passphrase protected keys.

Once custom certificates are made, users are responsible for managing them (e.g., updating them when new custom domains are added, renewing them when they expire).

If it has not already been encoded, then the certificate and key files may both contain text like the following snippet (with either `CERTIFICATE` or `KEY` in the begin/end tags, respectively):

```xml
-----BEGIN CERTIFICATE-----
base64encodedcertificate
-----END CERTIFICATE-----
```

To encode the contents of these files and use them, perform the following steps:

1. Create a new file for both the `key` and `cert` contents:

    ```bash
    touch originalkeyfile.key
    ```

    ```bash
    touch originalcertfile.crt
    ```

1. Open the `key` file and copy all of the contents **between and including the begin and end key tags**, and then copy them into the new file created for it (in this example, `originalkeyfile.key`). Save the file.

1. Open the `cert` file and copy all of the contents **between and including the begin and end cert tags**, and then copy them into the new file created for it (in this example, `originalcertfile.crt`). Save the file.

1. Run the following commands (or use any other preferred encoding method) to convert the files into new files with base64 encoding:

    ```bash
    openssl base64 -in originalkeyfile.key -out base64keyfile.key
    ```

    ```bash
    openssl base64 -in originalcertfile.crt -out base64certfile.crt
    ```

1. Copy all of the contents from the new, encoded `key` file (in this example, `base64keyfile.key`) and paste them into the `key` variable in your `webserver` service's `LCP.json` file.

1. Copy all of the contents from the new, encoded `cert` file (in this example, `base64certfile.crt`) and paste them into the `crt` variable in your `webserver` service's `LCP.json` file.

The `key` and `cert` values are now encoded and usable in your web server configuration.

```tip::
   It is possible to include multiple values for the ``cert`` by concatenating the base64-encoded results into a single string, within the ``crt`` field.
```

The Network page shows any custom certificates, with a maximum of one per service. For more information, see [Custom Domains](./custom-domains.md).

![DXP Cloud shows the status of SSL certificates that cover custom domains.](./load-balancer/images/04.png)

## Environment Variables Reference

| Name | Value | Description |
| --- | --- | --- |
| `cdn` | false | CDN is disabled by default; can be enabled by setting to `true` |
| `customDomains` | ["example.com", "www.example.com"] | Name of the custom domain; can list more than one |
| `targetPort` | 3000 | Port number for the load balancer |
| `key` | | SSL certificate's key in Base64 format |
| `crt` | | SSL certificate's crt in Base64 format |

## Additional Information

* [Private Network](./private-network.md)
* [VPN Integration Overview](./vpn-integration-overview.md)
* [Custom Domains](./custom-domains.md)
