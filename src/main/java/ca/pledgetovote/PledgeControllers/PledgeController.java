package ca.pledgetovote.PledgeControllers;

import ca.pledgetovote.model.Pledge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PledgeController {
    private List<Pledge> pledges = new ArrayList<>();
    private AtomicLong nextID = new AtomicLong();

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Springboot Java";
    }

    @PostMapping("/pledges")
    @ResponseStatus(HttpStatus.CREATED)
    public Pledge createNewPledge(@RequestBody Pledge pledge) {
        //Set pledge to have next ID
        pledge.setId(nextID.incrementAndGet());
        pledges.add(pledge);
        return pledge;
    }

    @GetMapping("/pledges")
    public List<Pledge> getAllPledges() {
        return pledges;
    }

    @GetMapping("/pledges/{id}")
    public Pledge getOnePledge(@PathVariable("id") long pledgeID,
                               @RequestBody Pledge newPledge
                               ) {
        for (Pledge pledge : pledges) {
            if (pledge.getId() == pledgeID) {
                pledges.remove(pledge);
                pledge.setId(pledgeID);
                pledges.add(newPledge);
                return pledge;
            }
        }
        throw new IllegalArgumentException();
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }

}
