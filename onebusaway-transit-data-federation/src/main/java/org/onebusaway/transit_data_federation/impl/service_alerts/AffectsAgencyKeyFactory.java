package org.onebusaway.transit_data_federation.impl.service_alerts;

import java.util.HashSet;
import java.util.Set;

import org.onebusaway.transit_data_federation.services.service_alerts.Situation;
import org.onebusaway.transit_data_federation.services.service_alerts.SituationAffects;

public class AffectsAgencyKeyFactory implements AffectsKeyFactory<String> {

  public static final AffectsAgencyKeyFactory INSTANCE = new AffectsAgencyKeyFactory();

  @Override
  public Set<String> getKeysForAffects(Situation situation,
      SituationAffects affects) {

    Set<String> v = new HashSet<String>();
    if( situation != null)
      v.add(situation.getId().getAgencyId());
    return v;
  }

}
