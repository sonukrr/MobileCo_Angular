import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllAccessoriesComponent } from './show-all-accessories.component';

describe('ShowAllAccessoriesComponent', () => {
  let component: ShowAllAccessoriesComponent;
  let fixture: ComponentFixture<ShowAllAccessoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllAccessoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllAccessoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
