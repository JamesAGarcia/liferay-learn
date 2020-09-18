# Resolving Conflicts

Liferay DXP's Publications tool provides a high level of process transparency that you can use to understand and resolve conflicts and other errors when they occur.

Generally, there are three types of conflicts you can encounter when making, publishing, or reverting changes: *Modification* conflicts, *Constraint* conflicts, and *Missing Parent* conflicts.

While Liferay DXP can automatically resolve some conflicts, others require manual intervention.

* [Automatically Resolved Conflicts](#automatically-resolved-conflicts)
* [Resolving Modification Conflicts](#resolving-modification-conflicts)
* [Resolving Constraint Conflicts](#resolving-constraint-conflicts)
* [Resolving Missing Parent Conflicts](#resolving-missing-parent-conflicts)

## Automatically Resolved Conflicts

Automatically recognize changes in Production, and communicates those changes to publications. <!--automatic conflict resolution is between Production and publications, given subsequent changes to Production--> This informs versions. When roles are updated in Production, changes are automatically communicated to each publication. Also, when a change to page name is published, that name change is automatically communicated to publications in progress, so that any name changes in those publications is registered as a name change of the new name. <!--essentially resolves a discrepancy between current Production and the publication's version of Production.-->

<!--Automatic resolution resolves conflicts by adding, modifying, or removing the conflicts from the publication. ??-->

## Resolving Modification Conflicts

Modification conflicts occur when the same item has been modified in Production and the publication being published.

## Resolving Constraint Conflicts

## Resolving Missing Parent Conflicts

Occurs when a parent is removed from Production while a new child has been created in the publication prepared for publishing.

e.g., deleting a folder from Production that contains a new folder in the publication

## Ways of Resolving Conflicts

Adding something in publication that is also added to Production.

Duplicate Assets/Entities: Ensure unique naming of assets/entities. Prompted to *View* or *Discard* duplicate.

View: opens a modal window with details for the conflicting changes.

Discard: redirects to the *Discard Changes* screen/page. Lists all changes that will be discarded. Click on *Discard* to permanently remove them from your publication.

Edit: Redirects to the cause of the conflict in the publication you're attempting to publish. You can resolve the conflict by editing the name.

Conflicting Changes to Assets/Entities: When the same asset or entity is modified in different publications or Production. *View*, *Edit*, or *Discard*.

When you click on *Discard*, you're directed to the *Discard Changes* screen/page. Lists the changes that will be discarded. Click on *Discard* to confirm your choice.

```warning::
   Discarding is permanent and cannot be reversed. Ensure you've __ before choosing to discard your changes
```

## Additional Information

* []()
* []()
