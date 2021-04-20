# Understanding the Dispatch Framework

Liferay Dispatch is a dynamic/versatile<!--w/c--> framework built on top of Liferay's Scheduler Engine. You can use it to add, execute, and schedule tasks with any custom logic across a Liferay instance.

The Dispatch framework consist of six essential parts:

* [`DispatchTaskExecutor`](#dispatchtaskexecutor)
* [`DispatchTrigger`](#dispatchtrigger)
* [`DispatchMessageListener`](#dispatchmessagelistener)
* [`DispatchTaskExecutorRegistry`](#dispatchtaskexecutorregistry)
* [`DispatchLog`](#dispatchlog)
* [`DispatchConfigurator`](#dispatchconfigurator)

## `DispatchTaskExecutor`

The [`DispatchTaskExecutor`](https://github.com/liferay/liferay-portal/blob/master/modules/apps/dispatch/dispatch-api/src/main/java/com/liferay/dispatch/executor/DispatchTaskExecutor.java) interface is used to create templates for Dispatch Tasks in a Liferay instance. Each implementation of `DispatchTaskExecutor` is registered as an OSGi component and contains the essential logic executed by the Dispatch Task. See [Creating a New Dispatch Task Executor](./creating-a-new-dispatch-task-executor.md) to learn more. <!--INTEGRATE: Each Dispatch Task is an instance of a Java class that implements the `DispatchTaskExecutor` interface and has the `dispatch.task.executor.name` and `dispatch.task.executor.type` OSGi component properties.-->

## `DispatchTrigger`

The [`DispatchTrigger`](https://github.com/liferay/liferay-portal/blob/master/modules/apps/dispatch/dispatch-api/src/main/java/com/liferay/dispatch/model/DispatchTrigger.java) interface extends `DispatchTriggerModel` and `PersistedModel`. This entity serves as a draft for Liferay (Quartz) trigger. Basically, it is a connection between `DispatchTaskExecutors` and the Liferay scheduler engine.

## `DispatchMessageListener`

The [`DispatchMessageListener`](https://github.com/liferay/liferay-portal/blob/master/modules/apps/dispatch/dispatch-service/src/main/java/com/liferay/dispatch/internal/messaging/DispatchMessageListener.java) class extends the `BaseMessageListener` class and is responsible for initiating the execution of all Dispatch Task Executors. This means a new Liferay trigger is created for each scheduled instance of the `DispatchTaskExecutor` service class. This trigger is created with the same destination (`liferay/dispatch/executor`) and has a payload(`dispatchTriggerId`) that connects the Liferay trigger with `DispatchTaskExecutor`. The Liferay Scheduler engine then triggers `DispatchMessageListener` at the appropriate time with a message (`dispatchTriggerId`). Using `dispatchTriggerId`, `DispatchMessageListener` finds and runs the appropriate instance of `DispatchTaskExecutor` using the `DispatchTaskExecutorRegistry`.

## `DispatchTaskExecutorRegistry`

The [`DispatchTaskExecutorRegistry`](https://github.com/liferay/liferay-portal/blob/master/modules/apps/dispatch/dispatch-api/src/main/java/com/liferay/dispatch/executor/DispatchTaskExecutorRegistry.java) interface holds references to all implementations of `DispatchTaskExecutor` in the portal and validates that each `dispatch.task.executor.type` OSGi property value is unique.

## `DispatchLog`

The [`DispatchLog`](https://github.com/liferay/liferay-portal/blob/master/modules/apps/dispatch/dispatch-api/src/main/java/com/liferay/dispatch/model/DispatchLog.java) interface extends `DispatchLogModel` and `PersistedModel`. This entity is responsible for persisting Dispatch task execution logs.

## `DispatchConfigurator`

The [`DispatchConfigurator`](https://github.com/liferay/liferay-portal/blob/master/modules/apps/dispatch/dispatch-service/src/main/java/com/liferay/dispatch/internal/messaging/DispatchConfigurator.java) class is responsible for configuring elements of the Dispatch framework, such as the `DispatchMessageListener` destination, `executorService` queue size and thread pool, `RejectedExecutionHandler`, and more.

## Additional Information

* [Using Dispatch](./using-dispatch.md)
* [Dispatch Reference](./dispatch-reference.md)
* [Creating a New Dispatch Executor](./creating-a-new-dispatch-task-executor.md)
