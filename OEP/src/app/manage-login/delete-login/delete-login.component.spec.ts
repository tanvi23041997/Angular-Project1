import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteLoginComponent } from './delete-login.component';

describe('DeleteLoginComponent', () => {
  let component: DeleteLoginComponent;
  let fixture: ComponentFixture<DeleteLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
