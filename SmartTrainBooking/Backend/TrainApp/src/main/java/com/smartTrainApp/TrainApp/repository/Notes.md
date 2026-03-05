JPQL is required here because the search involves joining multiple related entities (Train → TrainStation → Station) and applying a condition on stopOrder (source must come before destination).

Spring Data’s derived query methods only work for simple field-based lookups on a single entity, but they cannot handle complex joins with conditional comparisons like ts1.stopOrder < ts2.stopOrder.