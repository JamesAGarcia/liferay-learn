# Store Management Permissions Reference

Liferay Commerce provides out-of-the-box permissions to control access to Store Management applications and resources in the Global Menu (![Global Menu](../../images/icon-applications-menu.png)).

![Control access to Store Management applications and resources.](./store-management-permissions-reference/images/01.png)

You can manage Store Management permissions for user roles under *Commerce* &rarr; *Store Management* in the Define Permissions tab.  Assign permissions individually, or check *Action* to assign all permissions for an application or resource.

![Manage Store Management permissions for user roles in the Define Permissions tab.](./store-management-permissions-reference/images/02.png)

```note::
   The following article does not document permissions for related widgets.
```

## Standard Application Permissions

Application permissions define what actions can be performed in an application.

Store Management includes the following applications:

* **Channels**: This application is used to create and manage Channels, which are used to display Products and receive Orders.

* **Currencies**: This application is used to add and manage the currencies used within a Liferay instance. See [Currencies Reference](../../store-administration/currencies/currencies-reference.md) for more information.

All Store Management applications have the following permissions:

| Permission | Description |
| --- | --- |
| Access in Control Panel | Ability to access the application in the Global Menu |
| Configuration | Ability to view and set the application's configuration options |
| Permissions | Ability to view and modify the application's permissions |
| Preferences | Ability to view and set application preferences |
| View | Ability to view ... | <!--finish-->

## Related Resource Permissions

Resource permissions define what actions can be performed on resources displayed or managed within an application. Resources are any user-facing object, such as Catalogs, Price Lists, Orders, and Warehouses.

Store Management applications are connected to the following resources:

* **Commerce Channel** (listed under Channels): Channels are entities <!--w/c--> used to display Products and receive customer orders via a connected Site. Each Channel has its own workflow for orders, payment setting, shipping settings, tax calculations, and notifications. See [Managing Channels](../../starting-a-store/channels/managing-channels.md) and [Channels Reference Guide](../../starting-a-store/channels/channels-reference-guide.md) for more information.

* **Commerce Notification Template** (listed under Channels): Notification Templates are custom templates used to create notifications for specific Channel events.

* **Commerce Notification** (listed under Channels): Notifications are instances of a Notification Template created by an event trigger. They are displayed within the Channels application.

Both the *Channel* and *Notification Template* resources have the following permissions:

| Permission | Description |
|---|---|
| Delete | Grants ability to delete the application resource |
| Permissions | Ability to view and modify a resource's permissions  |
| Update | Grants ability to update a resource |
| View | Grants ability to view a resource |

*Notification* resources have the following unique permissions:

| Permission | Description |
|---|---|
| Add Notification Template | Ability to add a new Notification Template |
| Delete Notification Queue Entry | Ability to remove a Notification |
| Permissions | Ability to view and modify permissions for a Notification entry |
| Resend Notification Queue Entry | Ability to resend a Notification |
| View Notification Queue Entries | Ability to view Notifications within the queue |
| View Notification Templates | Ability to view existing Notification Templates |

## Additional Information

* [Introduction to Channels](../../starting-a-store/channels/introduction-to-channels.md)
* [Managing Channels](../../starting-a-store/channels/managing-channels.md)
* [Channels Reference Guide](../../starting-a-store/channels/channels-reference-guide.md)
