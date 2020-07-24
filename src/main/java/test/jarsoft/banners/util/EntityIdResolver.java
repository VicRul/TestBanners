package test.jarsoft.banners.util;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

public class EntityIdResolver implements ObjectIdResolver {

	private EntityManager entityManager;

	@Autowired
	public EntityIdResolver(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void bindItem(IdKey id, Object pojo) {

	}

	@Override
	public Object resolveId(IdKey id) {
		return entityManager.find(id.scope, Integer.parseInt(id.key.toString()));
	}

	@Override
	public ObjectIdResolver newForDeserialization(Object context) {
		return this;
	}

	@Override
	public boolean canUseFor(ObjectIdResolver resolverType) {
		return false;
	}

}