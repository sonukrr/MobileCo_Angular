import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllMobilesComponent } from './show-all-mobiles.component';

describe('ShowAllMobilesComponent', () => {
  let component: ShowAllMobilesComponent;
  let fixture: ComponentFixture<ShowAllMobilesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllMobilesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllMobilesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
