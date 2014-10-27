flume-interceptor-gerrit-trigger
===================

* Author: rinrinne a.k.a. rin_ne
* Repository: https://github.com/rinrinne/flume-interceptor-gerrit-trigger.git

Synopsis
-------------------

This is a flume interceptor for Gerrit Trigger. This adds some headers defined by [Gerrit Trigger] to event.

[Gerrit Trigger]: https://wiki.jenkins-ci.org/display/JENKINS/Gerrit+Trigger

Environments
-------------------

* `linux`
  * `java-1.6`
    * `gradle`

Build
-------------------

TO build library with gradle.

    ./gradlew build

How to setup in agent config
-------------------

```ini
<Agent>.sources = <Source1>
<Agent>.sources.<Source1>.interceptors = <Interceptor1>
<Agent>.sources.<Source1>.interceptors.<Interceptor1>.type = jp.glassmoon.flume.interceptor.gerrit.GerritTrigger$Builder
```

Configuration
-------------------

**Bold** is string value.

|name              | default value
|:-----------------|:-----------------
|name              | **gerrit**
|host              | **localhost**
|scheme            | **ssh**
|port              | 29418
|frontUrl          | **http://localhost/**
|version           | **2.8**

License
-------------------

The Apache Software License, Version 2.0

Copyright
-------------------

Copyright (c) 2014 rinrinne a.k.a. rin_ne
