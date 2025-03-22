import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { NgModule } from "@angular/core";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutingModule,
        AppComponent
    ],
})
export class AppModule { }