import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestdemoComponent } from './testdemo.component';
//fdescribe
fdescribe('TestdemoComponent', () => {
  let component: TestdemoComponent;
  let fixture: ComponentFixture<TestdemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestdemoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TestdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  //@Test
  //fit
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return sum of numbers',()=>
  {
    const result = component.sumOfTwoNumber(2,3);
    expect(result).toEqual(5);
  })

  it('should return even value',()=>
  {
    const result = component.evenOrOdd(2);
    expect(result).toEqual('even');
  })

  it('should return even value',()=>
  {
    const result = component.evenOrOdd(3);
    expect(result).toEqual('odd');
  })
  
});
