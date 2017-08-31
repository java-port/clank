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

package org.llvm.support;

import java.util.ArrayList;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;

/*template <typename DerivedT> TEMPLATE*/

/// \brief CRTP base class providing obvious overloads for the core \c
/// Allocate() methods of LLVM-style allocators.
///
/// This base class both documents the full public interface exposed by all
/// LLVM-style allocators, and redirects all of the overloads to a single core
/// set of methods which the derived class must define.
//<editor-fold defaultstate="collapsed" desc="llvm::AllocatorBase">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 42,
 FQN = "llvm::AllocatorBase", NM = "_ZN4llvm13AllocatorBaseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm13AllocatorBaseE")
//</editor-fold>
public abstract class AllocatorBase</*typename*/ DerivedT extends AllocatorBase> implements Destructors.ClassWithDestructor, NativeMemory.Allocator {
  // JAVA: consistency check
  private final static boolean TRACE_ALLOCATOR = NativeTrace.CHECK_ALLOCATOR;
  private final int AllocatorIndex;
  private final Exception stack;
  private Exception unregisterStack;
  protected AllocatorBase() {
    if (TRACE_ALLOCATOR) {
      this.stack = new Exception("Not Freed Allocator (creation stack)");
      this.AllocatorIndex = register(AllocatorBase.this);
    } else {
      this.stack = null;
      this.AllocatorIndex = 0;
    }
  }
  
  public String toString() {
    return ""; // NOI18N
  }

  @Override
  public void $destroy() {
    if (TRACE_ALLOCATOR) {
      unregister(this);
    }
  }
  
  public abstract /*size_t*/long getTotalMemory();
  
  private static final ArrayList<AllocatorBase> AllocatorStacks = new ArrayList<>(0);

  private static synchronized int register(AllocatorBase alloc) {    
    assert alloc.AllocatorIndex == 0 : "must be not initialized";
    int index = AllocatorStacks.size();
    AllocatorStacks.add(alloc);
    return index;
  }

  private static synchronized void unregister(AllocatorBase alloc) {
    AllocatorBase removed = AllocatorStacks.set(alloc.AllocatorIndex, null);
    if (TRACE_ALLOCATOR) {
      if (removed != alloc) {
        assert alloc.stack != null : "must have allocation stack";
        assert alloc.unregisterStack != null : "must have unregister stack";
        new Exception("can not unregister twice").printStackTrace(System.err);
        alloc.unregisterStack.printStackTrace(System.err);
        alloc.stack.printStackTrace(System.err);
      } else {
        alloc.unregisterStack = new Exception("Unregistered at:");
      }
    }
    assert removed == alloc: "can not unregister twice. See err file for more details";
  }
  
  public static void DumpDebugTrace(raw_ostream out) {
    if (TRACE_ALLOCATOR) {
      synchronized (AllocatorBase.class) {
        int count = 0;
        long/*uint64_t*/ knownSize = 0;
        StringBuilder knownSizes = new StringBuilder();
        for (AllocatorBase alloc : AllocatorStacks) {
          if (alloc != null) {
            StackTraceElement knownStaticHelper = knownStaticHelpers(alloc.stack);
            if (knownStaticHelper != null) {
              /*size_t*/long totalMemory = alloc.getTotalMemory();
              knownSize += totalMemory;
              if (knownSizes.length() != 0) {
                knownSizes.append("\n\t+");
              } else {
                knownSizes.append(" ");
              }
              knownSizes.append("[").append(NativeTrace.formatNumber(totalMemory)).append("]");
              knownSizes.append(" at ").append(knownStaticHelper.toString());
            } else {
              alloc.stack.printStackTrace(System.err);
              count++;
            }
          }
        }
        if (knownSizes.length() > 0) {
          knownSizes.insert(0, " = Allocations:\n\t").insert(0, NativeTrace.formatNumber(knownSize));
        } else {
          knownSizes.append("<Empty>");
        }
        out.$out(String.format("%30s:\t", "Known Allocators Consume")).$out(knownSizes.toString()).$out($LF);;
        out.$out(String.format("%30s:\t", "NOT Destroyed Allocators")).$out(NativeTrace.formatNumber(count)).$out($LF);;
      }
    }
  }
  
  private static StackTraceElement knownStaticHelpers(Exception stack) {
    assert stack != null;
    for (StackTraceElement stackElem : stack.getStackTrace()) {
      String className = stackElem.getClassName();
      String methodName = stackElem.getMethodName();
      // we have some places in code with static allocation of caches
      if ("<clinit>".equals(methodName)) {
        if ("org.clang.tools.services.support.FileInfo".equals(className)) {
          return stackElem;
        }
        if ("org.clang.tools.services.impl.PreprocessorInitializer".equals(className)) {
          return stackElem;
        }
      }
    }
    return null;
  }
  
}
