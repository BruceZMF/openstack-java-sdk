package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaCreateSecurityGroupRuleRequest;
import org.openstack.model.compute.NovaSecurityGroupRule;

public class SecurityGroupRulesResource extends Resource {

    public NovaSecurityGroupRule post(Map<String,Object> properties, Entity<NovaCreateSecurityGroupRuleRequest> rule) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).post(rule, NovaSecurityGroupRule.class);
	}

    public SecurityGroupRuleResource securityGroupRule(String id) {
    	return new SecurityGroupRuleResource(target.path("/{id}").pathParam("id", id));
    }

}