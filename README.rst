=========================================
GeoCam Memo for Android
=========================================

.. sectnum::

.. contents:: Contents

About
-----

The GeoCam Project helps people better understand and respond to disasters.
GeoCam consists of a GPS-enabled camera (or cell phone) and a web app for
sharing geotagged photos and other geospatial data.

GeoCam Memo For Android is the android component of a scribing and 
note-taking application intended for use by search team members as they 
canvas the scene of a disaster. Notes can be recorded using text or audio 
and various forms of attachments (including but not limited to images) can 
be attached for transmission to a central server. All messages can be 
geotagged and categorized before saving to provide proper context when 
analyzing them via a web interface at a later time.

News
----

Visit http://sites.google.com/site/geocampracticum2011/ and http://disastercam.blogspot.com/ for updates.

Setup
-----
We used eclipse to do development of both the GeoCam Memo application and its associated Robolectric test project. As such, this README will provide directions on how to import and set up the projects in your eclipse instance.

Dependencies
~~~~~~~~~~~~
  * Eclipse IDE for Java Developers; Galileo or newer (http://www.eclipse.org/downloads/packages/)
  * The Android SDK with the 2.2 Google API (http://developer.android.com/sdk/installing.html)
  * The GeoCamMemoWeb project and its dependencies (https://github.com/cheeseinvert/geocamMemoWeb)

1. Once all dependencies have been installed, clone the GeoCamMemoForAndroid repository to the path of your choice ::

      git clone git@github.com:cheeseinvert/geocamMemoForAndroid.git

2. Launch your Eclipse instance and from the File menu, select `Import...`

   a. Select `General -> Existing Projects into Workspace`; Next >

   b. In the `Select root directory:` field, provide the location to which you cloned the repository
   
   c. In the `Projects` field, put a check box into both the `GeoCamMemoForAndroid` and `GeoCamMemoForAndroidTest` fields. You may need to click the Refresh button if the projects are not visible. Choose whether you'd like to copy the contents into your workspace and click `Finish`

Running
-------
From eclipse, select `Run > Run As... > Android Application` and select your target. For more information on running / emulating android applications from eclipse, see the official Android documentation: http://developer.android.com/guide/developing/building/building-eclipse.html

Testing
-------
The GeoCamMemoForAndroid project uses Robolectric in order to remove reliance on the emulator. Setting this up requires the following steps:

1. Right click the GeocamMemoForAndroidTest project from the package or file explorer and select `Run As > Run Configurations ...`

2. If a GeocamMemoForAndroidTest in the Junit section, select it. If no such entry exists, double click on the JUnit section to create one.

3. On the Test tab, set the `Test runner:` field to JUnit 4.

4. On the Arguments tab, choose the `Other` radio button in the `Working Directory` section. Click the `Workspace...` button.

   a. Click the GeocamMemoForAndroid project then click `OK`
   
5. Click `Run` to launch the test suite. If prompted to select a test runner, select the Eclipse JUnit test runner.

Future runs can be initiated by right clicking on the project and selecting `Run As > GeocamMemoForAndroidTest` among other methods. See eclipse documentation for additional shortcuts and methods of initiating junit tests.

.. o  __BEGIN_LICENSE__
.. o  Copyright (C) 2008-2010 United States Government as represented by
.. o  the Administrator of the National Aeronautics and Space Administration.
.. o  All Rights Reserved.
.. o  __END_LICENSE__
