import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ShowAllMobilesComponent } from './components/show-all-mobiles/show-all-mobiles.component';
import { ShowAllAccessoriesComponent } from './components/show-all-accessories/show-all-accessories.component';
import { SearchComponent } from './components/search/search.component';
import { CartItemsComponent } from './components/cart-items/cart-items.component';
import { AppComponent } from './app.component';

const routes: Routes = [
   { path: '',redirectTo: '/navbar', pathMatch: 'full' },
  {path:'loginpage',component:LandingpageComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'showMobiles',component:ShowAllMobilesComponent},
  {path:'showAcc',component:ShowAllAccessoriesComponent},
  {path:'search/:text',component:SearchComponent},
  {path:'cartItems/:id',component:CartItemsComponent},
  {path:'home',component:AppComponent},
  // {path:'**',component:PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
