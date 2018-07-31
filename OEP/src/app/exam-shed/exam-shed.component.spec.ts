import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamShedComponent } from './exam-shed.component';

describe('ExamShedComponent', () => {
  let component: ExamShedComponent;
  let fixture: ComponentFixture<ExamShedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamShedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamShedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
