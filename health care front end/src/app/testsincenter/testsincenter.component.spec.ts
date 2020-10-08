import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestsincenterComponent } from './testsincenter.component';

describe('TestsincenterComponent', () => {
  let component: TestsincenterComponent;
  let fixture: ComponentFixture<TestsincenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestsincenterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestsincenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
