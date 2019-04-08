import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule }   from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { ShowAllMobilesComponent } from './components/show-all-mobiles/show-all-mobiles.component';
import { ShowAllAccessoriesComponent } from './components/show-all-accessories/show-all-accessories.component';
import { SearchComponent } from './components/search/search.component';

import { CartItemsComponent } from './components/cart-items/cart-items.component';





@NgModule({
  declarations: [
    AppComponent,
    LandingpageComponent,
    NavbarComponent,
    RegisterComponent,
    LoginComponent,
    ShowAllMobilesComponent,
    ShowAllAccessoriesComponent,
    SearchComponent,
    CartItemsComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
