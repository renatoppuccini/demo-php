# demo-php

This is a single file PHP application that I use to demonstrate Openshift :)
OpenShift Tasks: JAX-RS, JPA quickstart 
==============================

PIPELINE Configuration
-----------
a
Adding serviceaccount with imagePuller policy to realize deploy in different envs

  ```

oc new-project cicd

oc policy add-role-to-group system:image-puller system:serviceaccounts:app-qa -n cicd
oc policy add-role-to-group system:image-puller system:serviceaccounts:app-prod -n cicd

  ```
