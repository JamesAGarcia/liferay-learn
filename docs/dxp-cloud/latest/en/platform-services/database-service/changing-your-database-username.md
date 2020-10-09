# Changing Your Database Username

The MySQL username is defined by the `lcp-secret-database-user` secret and can be changed at any time. When this value is changed, a user with the new credentials is created in your database, and the previous username is removed when the service restarts.

However, before changing the secret's value, you can add the current username to a list of allowed users using the `LCP_DATABASE_USER_WHITELIST` variable. User credentials added in this way are retained and remain associated with your database even after the service is updated with a new secret value.

Keep in mind that changing the username can affect other service connected to the database.

```note::
   If no database username secret exists, then your Project service uses the ``LCP_MASTER_USER_NAME`` variable. This variable is defined in the ``LCP.json`` file and uses ``dxpcloud`` as its default value.
```

## Retaining Database Usernames

Follow these steps to retain the current username by adding it to the list of allowed users:

1. Go to the dedicated database service page in the desired Project environment.

1. Click on the *Environment Variables* tab.

1. Enter `LCP_DATABASE_USER_WHITELIST` under *Regular variables*, and enter the username you want to retain as its *value*. You can enter multiple usernames by separating with with a space and/or comma.

1. Click on *Save Changes*.

Once saved, the database service automatically restarts and adds the current credentials to the list of allowed users. After the service has finished restarting, proceed to change the `lcp-secret-database-user` secret.

## How to Change Your Database Username

Follow these steps to change your database username:

1. Go to the desired Project environment, and click on *Settings* in the environment menu.

1. In the *Secrets* section, click on the *Actions* button for `lcp-secret-database-user`, and select *Edit*.

1. In the *Value* section, click on *Show* to reveal and enable editing for the secret's value. Then, set a new value.

   You can optionally select which users can view the secret value, as well as which services use the secret.

1. Use the *Publish secret* checkboxes to acknowledge the impact of your changes will have on connected services.

1. Click on *Publish Changes*.

Once published, all connected services will restart and stop receiving requests for some minutes. They may also behave differently depending on the secret's usage. When the service starts up, the environment variables are read and the users are updated in the database server.

## Additional Information

* [Database Service](./database-service.md)
* [Changing your Database Password](./changing-your-database-password.md)
* [Managing Secure Environment Variables with Secrets](../../infrastructure-and-operations/security/managing-secure-environment-variables-with-secrets.md)
