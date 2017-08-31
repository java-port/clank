/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clank.support;


import java.util.IdentityHashMap;
import java.util.LinkedList;
import static org.clank.support.Native.$toConst;
import org.clank.support.aliases.*;
import org.clank.support.NativeCallback.*;
import static org.clank.support.NativeTrace.CHECK_STD_PTR_ACCESS_DESTROYED;

/**
 * This class is used to manage externally created type$ptr<?> with possible trailings object after $this.
 * @author Vladimir Voskresensky
 */
public final class ThreadLocalThisSupplier<T> {
  private final ThreadLocal<ThisMemoryPointerForContstructor<T>> ThreadLocals;
  private final String id;
  
  private ThreadLocalThisSupplier(TwoTypes2Bool<T, type$ptr<?>> assertConsumedCallback, String id, boolean allowNullMemoryAssignedToSupplier) {
    this.ThreadLocals = ThreadLocal.withInitial(()->new ThisMemoryPointerForContstructor(assertConsumedCallback, id, allowNullMemoryAssignedToSupplier));
    this.id = id;
  }

  public static <T> ThreadLocalThisSupplier<T> Create(TwoTypes2Bool<T, type$ptr<?>> assertConsumedCallback, String id, boolean allowNullMemoryAssignedToSupplier) {
    return new ThreadLocalThisSupplier(assertConsumedCallback, id, allowNullMemoryAssignedToSupplier);
  }
    
  public type$ptr<?> assignMemory(type$ptr<?> Mem) {
    return ThreadLocals.get().assignMemory(Mem);
  }
  
  public type$ptr<?> consumeAssignedMemory(T createdObj) {
    return ThreadLocals.get().consumeAssignedMemory(createdObj);
  }
  
  public type$ptr<?> consumeAssignedMemory$GetThisPlus1(T createdObj) {
    type$ptr<?> $This = consumeAssignedMemory(createdObj);
    assert !isNullMemoryMarker($This) || ThreadLocals.get().allowNullMemoryAssignedToSupplier;
    return $This == null ? null : $This.$add(1);
  }
  
  public boolean assertConsumed(T createdObj, type$ptr<?> Mem) {
    return ThreadLocals.get().assertConsumed(createdObj, Mem);
  }
  
  private static final class ThisMemoryPointerForContstructor<T> {
    private final TwoTypes2Bool<T, type$ptr<?>> assertConsumed;
    private final LinkedList<type$ptr<?>> MemoryStack = new LinkedList<>();
    private final String id;
    private final boolean allowNullMemoryAssignedToSupplier;
    private Throwable assignedStack = null;

    private ThisMemoryPointerForContstructor(TwoTypes2Bool<T, type$ptr<?>> assertConsumed, String id, boolean allowNullMemoryAssignedToSupplier) {
      assert assertConsumed != null;
      this.assertConsumed = assertConsumed;
      this.id = id;
      this.allowNullMemoryAssignedToSupplier = allowNullMemoryAssignedToSupplier;
    }

    private type$ptr<?> assignMemory(type$ptr<?> Mem) {
      assert checkBeforeUse();
      assert Mem != null || allowNullMemoryAssignedToSupplier;
      type$ptr<?> Memory = (Mem == null ? NULL_MEMORY : Mem);
      MemoryStack.addLast(Memory);
      return Memory;
    }
    private type$ptr<?> consumeAssignedMemory(T createdObj) {
      assert allowNullMemoryAssignedToSupplier || !this.MemoryStack.isEmpty() : "must be initialized before consume. Forgot to wrap in Create/CreateDeserialized into " + id + ".$new?";
      type$ptr Out;
      if (allowNullMemoryAssignedToSupplier && this.MemoryStack.isEmpty()) {
        // we must assert here, but for now just register the problem
//        NativeTrace.printStackTraceOnce(new IllegalStateException("ThreadLocalThisSupplier expects memory to be assigned. Wrap 'new Class' into $new wrapper: " + NativeTrace.getIdentityStr(createdObj)));
        Out = null;
      } else {
        Out = this.MemoryStack.removeLast();
      }
      assert (allowNullMemoryAssignedToSupplier && isNullMemoryMarker(Out)) || (Out.$star() == null): "must be not unused, but have: " + NativeTrace.getIdentityStr(Out.$star());
      if (!isNullMemoryMarker(Out)) {
        assert Out.$star() == null : "Must be empty slot " + NativeTrace.getIdentityStr(Out.$star());
        Out.$set(createdObj);
      }
      return Out;
    }
    private boolean assertConsumed(T createdObj, type$ptr<?> Mem) {
      assert assertConsumed.$call(createdObj, Mem);
      assert (allowNullMemoryAssignedToSupplier && isNullMemoryMarker(Mem)) || (Mem.$star() == createdObj) : "createdObj should be in Mem, but got: " + Mem.$star();
      return true;
    }

    private boolean checkBeforeUse() {
      if (!this.MemoryStack.isEmpty()) {
        Object error = null;
        for (type$ptr<?> Memory : MemoryStack) {
          if (!isNullMemoryMarker(Memory)) {
            if (Memory.$star() != null) {
              error = Memory.$star();
              break;
            }
          }
        }
        if (error != null) {
          String prefix = "";
          if (CHECK_STD_PTR_ACCESS_DESTROYED) {
            NativeTrace.printStackTraceOnce(assignedStack);
          } else {
            prefix = "Run with -Dclank.check.access.destroyed=true to see assign point:\n";
          }
          NativeTrace.printStackTraceOnce(new IllegalStateException(prefix + "ThreadLocalThisSupplier expects previous memory to be consumed or we need to support stack " + NativeTrace.getIdentityStr(error)));
        }
      }
      if (CHECK_STD_PTR_ACCESS_DESTROYED) {
        if (this.MemoryStack.isEmpty()) {
          assignedStack = new Exception("Initialization point of not consumed memory");
        }
      }
      return true;
    }
    
    @Override
    public String toString() {
      return "[" + id + "] thread local $this holder";
    }        
  }  

  private static final type$ptr<?> NULL_MEMORY = $toConst(NativePointer.create_type$ptr());
  public static boolean isNullMemoryMarker(type$ptr<?> Mem) {
    return Mem == null || Mem == NULL_MEMORY;
  }

  @Override
  public String toString() {
    return "[" + id + "] $this supplier";
  }        
}
