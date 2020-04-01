#!/usr/bin/env bash

echo "Appending CLI operations to ${CLI_SCRIPT_FILE}"

echo "
  /subsystem=datasources/data-source=database_server-DATABASE_SERVER:write-attribute(name=pool-use-strict-min, value=true)
  /subsystem=datasources/data-source=database_server-DATABASE_SERVER:write-attribute(name=idle-timeout-minutes, value=5)
" >> "${CLI_SCRIPT_FILE}"
