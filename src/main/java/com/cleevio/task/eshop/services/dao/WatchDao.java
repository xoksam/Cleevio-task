package com.cleevio.task.eshop.services.dao;

import com.cleevio.task.eshop.common.exceptions.EntityNotFoundException;
import com.cleevio.task.eshop.model.watch.QWatch;
import com.cleevio.task.eshop.model.watch.Watch;
import org.springframework.stereotype.Repository;

@Repository
public class WatchDao extends AbstractCommonDao {

    public Watch findWatchById(Long watchId) {
        var qWatch = QWatch.watch;

        var query = queryFactory
                .selectFrom(qWatch)
                .where(qWatch.id.eq(watchId));

        var watch = query.fetchFirst();

        if (watch == null) {
            throw new EntityNotFoundException(Watch.class, "id", watchId);
        }

        return watch;
    }

}
