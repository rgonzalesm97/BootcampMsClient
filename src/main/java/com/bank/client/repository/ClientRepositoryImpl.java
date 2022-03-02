package com.bank.client.repository;

import java.util.UUID;
import java.util.function.Function;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.repository.query.FluentQuery.ReactiveFluentQuery;
import org.springframework.stereotype.Repository;

import com.bank.client.model.dao.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Primary
public class ClientRepositoryImpl implements ClientRepository{
	
	private final static String KEY = "CLIENT";

    private final ReactiveRedisOperations<String, Client> redisOperations;
    private final ReactiveHashOperations<String, String, Client> hashOperations;

    @Autowired
    public ClientRepositoryImpl(ReactiveRedisOperations<String, Client> redisOperations) {
        this.redisOperations = redisOperations;
        this.hashOperations = redisOperations.opsForHash();
    }

	@Override
	public <S extends Client> Mono<S> insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Flux<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Flux<S> insert(Publisher<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Flux<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Flux<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Client> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Mono<S> save(S entity) {
		return hashOperations.put(KEY, entity.getId(), entity).map(isSaved -> entity).thenReturn(entity);
	}

	@Override
	public <S extends Client> Flux<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Flux<S> saveAll(Publisher<S> entityStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Client> findById(String id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Mono<Client> findById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Client> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Client> findAllById(Publisher<String> idStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Long> count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return hashOperations.remove(KEY, id).then();
	}

	@Override
	public Mono<Void> deleteById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Iterable<? extends Client> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Publisher<? extends Client> entityStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Mono<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Mono<Long> count(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client> Mono<Boolean> exists(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Client, R, P extends Publisher<R>> P findBy(Example<S> example,
			Function<ReactiveFluentQuery<S>, P> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}    
    
}
