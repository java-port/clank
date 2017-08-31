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

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import org.clank.support.*;
import org.clank.support.NativeMemory.Allocator;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;


/// BumpPtrAllocator - This allocator is useful for containers that need
/// very simple memory allocation strategies.  In particular, this just keeps
/// allocating memory, and never deletes it until the entire block is dead. This
/// makes allocation speedy, but must only be used when the trade-off is ok.
//<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 354,
 FQN = "llvm::BumpPtrAllocator", NM = "_ZN4llvm16BumpPtrAllocatorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -filter=llvm::BumpPtrAllocator",
 notes = Converted.Notes.FAILED)
//</editor-fold>
public class BumpPtrAllocator extends BumpPtrAllocatorImpl {

  public BumpPtrAllocator() {
  }

  public BumpPtrAllocator(Allocator Allocator) {
    super(Allocator);
  }

  public BumpPtrAllocator(Allocator Allocator, /*size_t*/int SlabSize) {
    super(Allocator, SlabSize);
  }

  public BumpPtrAllocator(Allocator Allocator, /*size_t*/int SlabSize, /*size_t*/int SizeThreshold) {
    super(Allocator, SlabSize, SizeThreshold);
  }
  
  //JAVA:
  public BumpPtrAllocator(Allocator Allocator, /*size_t*/int SlabSize, /*size_t*/int SizeThreshold, /*size_t*/int MaxSlabSize) {
    super(Allocator, SlabSize, SizeThreshold, MaxSlabSize);
  }

  public BumpPtrAllocator(BumpPtrAllocatorImpl Old) {
    super(Old);
  }
  
  /// Allocate space, but do not construct, one object.
  ///
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocator::Allocate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 156,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -filter=llvm::BumpPtrAllocator::Allocate")
  //</editor-fold>
  public </*typename*/ T> void$ptr /*P*/ Allocate(Class<T> cls) {
    try {
      Constructor constructor = cls.getDeclaredConstructor();
      constructor.setAccessible(true);
      return create_type$ptr(constructor.newInstance());
    } catch (java.lang.NoSuchMethodException e) {
      assert false : "Not defined constructor without parameters for " + cls;
    } catch (Exception ex) {
      NativeTrace.printStackTraceOnce(ex);
    }
    return create_type$ptr((T) null);
  }

  @Override
  public char$ptr Allocate(/*size_t*/int Size) {
    return Allocate(Size, 8);
  }

  public int$ptr AllocateInt(/*size_t*/int size) {
    return create_int$ptr(new$int(size));
  }  
  
  /// Allocate space for a specific count of elements and with a specified
  /// alignment.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BumpPtrAllocator::Allocate">
//  @Converted(kind = Converted.Kind.DUMMY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Allocator.h", line = 170,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -filter=llvm::BumpPtrAllocator::Allocate")
//  //</editor-fold>
//  public </*typename*/ T> T /*P*/ Allocate_T(Class<T> clz, /*size_t*/int Num, /*size_t*/int Alignment) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
  public </*typename*/ T> type$ptr<T> /*P*/ Allocate_T(Class<T> clz, /*size_t*/int Num) {
    return Allocate_T(clz, Num, sizeof(clz));
  }
  public </*typename*/ T> type$ptr<T> /*P*/ Allocate_T(Class<T> clz, /*size_t*/int Num, /*size_t*/int Alignment) {
    NativeTrace.trace("creating array " + clz.getName() + "[" + Num + "]", NativeTrace.TRACE_MEMORY);
    try {
      T array[] = (T[]) Array.newInstance(clz, (int)Num);
      for (int i = 0; i < array.length; i++) {
        array[i] = NativeType.createDefaultValue(clz);
      }
      return create_type$ptr(array);
    } catch (Exception ex) {
      throw new AssertionError(ex);
    }
  }
}
