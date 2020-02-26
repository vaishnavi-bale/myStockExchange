import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCompanylistComponent } from './user-companylist.component';

describe('UserCompanylistComponent', () => {
  let component: UserCompanylistComponent;
  let fixture: ComponentFixture<UserCompanylistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserCompanylistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCompanylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
