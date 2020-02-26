import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserIpolistComponent } from './user-ipolist.component';

describe('UserIpolistComponent', () => {
  let component: UserIpolistComponent;
  let fixture: ComponentFixture<UserIpolistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserIpolistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserIpolistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
