package co.edu.eci.LaReserva.persistence.cache;

import co.edu.eci.LaReserva.entities.Cancha;
import co.edu.eci.LaReserva.entities.Sede;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LaReservaCache {

    private final HashOperations hashOperations;
    private final RedisTemplate redisTemplate;

    public LaReservaCache(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
        redisTemplate.expire("SEDE", 1, TimeUnit.MINUTES);
        redisTemplate.expire("CANCHA", 1, TimeUnit.MINUTES);
    }

    public void putSede(Sede payLoad) {
        this.hashOperations.put("SEDE", "sede:" + payLoad.getId(), payLoad);
    }

    public Sede getSede(Integer id) {
        return (Sede) this.hashOperations.get("SEDE", "sede:" + id);
    }
    
    public Boolean sedeEnCache(Integer id) {
        return this.hashOperations.hasKey("SEDE", "sede:" + id);
    }
    
    public void putCancha(Cancha payLoad) {
        this.hashOperations.put("CANCHA", "cancha:" + payLoad.getId(), payLoad);
    }

    public Cancha getCancha(Integer id) {
        return (Cancha) this.hashOperations.get("CANCHA", "cancha:" + id);
    }
    
    public Boolean canchaEnCache(Integer id) {
        return this.hashOperations.hasKey("CANCHA", "cancha:" + id);
    }
}
