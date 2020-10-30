package com.eandbsolutions.modules;

import com.eandbsolutions.models.Engine;
import com.eandbsolutions.models.Make;
import dagger.Module;
import dagger.Provides;

@Module
public class VehiclesModule {
    @Provides
    public Make provideMake() {
        return new Make();
    }

    @Provides
    public Engine provideEngine() {
        return new Engine();
    }
}
