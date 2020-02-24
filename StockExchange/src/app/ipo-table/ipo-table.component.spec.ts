import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IpoTableComponent } from './ipo-table.component';

describe('IpoTableComponent', () => {
  let component: IpoTableComponent;
  let fixture: ComponentFixture<IpoTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IpoTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IpoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
