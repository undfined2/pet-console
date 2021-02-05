# PetStore Console Application

Hi guys,

Thanks for checking out my console app. I found it a bit challenging as I hadn't worked with a specific console application before, rather than with pre-existing code in the format of MVC RESTful APIs.


# Some thoughts on the exercise

- I am not at all sure about structure - some I made up (writer package? RestService - that one may be convention, I'm actually not sure), some I knew from experience.
- I don't handle any exceptions, just dodge a few nulls, and I even do that in what felt like pretty dodgy places (like the getters of the model objects..). I'm not too concerned about that as it is  a fairly static payload, but I would have liked to spend some time handling exceptions if I didn't spend so long getting across the basics.
- I made up a toString method which follows no convention. I presumed the console readout should be human-readable rather than serialised data
- I would have also liked to include some command line args to control the data output (or specify variables of the service which would be a more sensible approach), but it wasn't part of the mvp, so I didn't platinum plate
 - There are a bunch of cool spring features such as @Autowired which I could have utilised but didn't as, again, I would need to spend more time working out how best to implement them for this kind of app.
- Of course the "logger" class should be a transformer and should return an object which gets passed to a writer service or, etc, but it is what it is...
- The main thing is it does what it's supposed to do - so far as I can tell, and I'm happy with that.


# How the app works
- No bells or whistles, run the JAR and so long as the environment where it runs has unrestricted internet access, it should contact the rest service, process the data and print the requested information (ordered first by Category, then by reverse pet name)
