package ca.pledgetovote.PledgeControllers;

import ca.pledgetovote.model.Pledge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Pledge createNewPledge(@RequestBody Pledge pledge) {
        //Set pledge to have next ID
        pledge.setId(nextID.incrementAndGet());
        pledges.add(pledge);
        return pledge;
    }
    @GetMapping("/pledges")
    public List<Pledge> getAllPledges(){
        return pledges;
    }

}
