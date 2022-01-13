package com.sma.demo.configcenter;

import java.util.HashMap;

public   class ConfigsUtils {
      public ConfigsUtils() {
      }

      public static HashMap<String, String> transformTenantParam(String tenantId, String userId) {
          HashMap<String, String> map = new HashMap();
          map.put("tenantId", tenantId);
          map.put("userId", userId);
          return map;
      }
  }