package com.example.repository;

import com.example.dto.response.CalendarResponse;
import com.example.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long>{
    @Query("select new com.example.dto.response.CalendarResponse(c.id,c.user.fullName,c.user.icon,c.startDate,c.endDate," +
            "GROUP_CONCAT(h.name), GROUP_CONCAT(h.description),GROUP_CONCAT(h.goal)," +
            "GROUP_CONCAT(h.frequency),GROUP_CONCAT(h.isDone)) from Calendar c left join Habit h on c.id=h.calendar.id where c.user.id=?1" +
            "GROUP BY c.id, c.user.fullName, c.user.icon, c.startDate, c.endDate")
    Optional<CalendarResponse> getByUserId(Long userId);

//    @Query("select new com.example.dto.response.CalendarResponse(c.id,c.user.fullName,c.user.icon,c.startDate,c.endDate," +
//            "h.name,h.description,h.goal, h.frequency,h.isDone) " +
//            "from Calendar c left join Habit h on c.id=h.calendar.id")
//    List<CalendarResponse> getAll();
}
