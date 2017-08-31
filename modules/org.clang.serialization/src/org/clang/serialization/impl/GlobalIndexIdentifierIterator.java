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

package org.clang.serialization.impl;

import org.clank.support.*;
import org.clang.basic.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.OnDiskIterableChainedHashTable.iterator_base;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalIndexIdentifierIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 861,
 FQN="(anonymous namespace)::GlobalIndexIdentifierIterator", NM="_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorE")
//</editor-fold>
public class GlobalIndexIdentifierIterator extends /*public*/ IdentifierIterator implements Destructors.ClassWithDestructor {
  /// \brief The current position within the identifier lookup table.
  private OnDiskIterableChainedHashTable.key_iterator<StringRef, StringRef> Current;
  
  /// \brief The end position within the identifier lookup table.
  private OnDiskIterableChainedHashTable.key_iterator<StringRef, StringRef> End;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalIndexIdentifierIterator::GlobalIndexIdentifierIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 869,
   FQN="(anonymous namespace)::GlobalIndexIdentifierIterator::GlobalIndexIdentifierIterator", NM="_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorC1ERN4llvm30OnDiskIterableChainedHashTableINS_26IdentifierIndexReaderTraitEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorC1ERN4llvm30OnDiskIterableChainedHashTableINS_26IdentifierIndexReaderTraitEEE")
  //</editor-fold>
  public /*explicit*/ GlobalIndexIdentifierIterator(final OnDiskIterableChainedHashTable<StringRef, StringRef, SmallVectorUInt> /*&*/ Idx) {
    // : IdentifierIterator(), Current(), End() 
    //START JInit
    super();
    this.Current = new OnDiskIterableChainedHashTable.key_iterator<StringRef, StringRef>();
    this.End = new OnDiskIterableChainedHashTable.key_iterator<StringRef, StringRef>();
    //END JInit
    Current.$assignMove(Idx.key_begin());
    End.$assignMove(Idx.key_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalIndexIdentifierIterator::Next">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 874,
   FQN="(anonymous namespace)::GlobalIndexIdentifierIterator::Next", NM="_ZN12_GLOBAL__N_129GlobalIndexIdentifierIterator4NextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_129GlobalIndexIdentifierIterator4NextEv")
  //</editor-fold>
  @Override public StringRef Next()/* override*/ {
    if (iterator_base.$eq_iterator_base$C(Current, End)) {
      return new StringRef();
    }
    
    StringRef Result = Current.$star();
    Current.$preInc();
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalIndexIdentifierIterator::~GlobalIndexIdentifierIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 861,
   FQN="(anonymous namespace)::GlobalIndexIdentifierIterator::~GlobalIndexIdentifierIterator", NM="_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Current=" + Current // NOI18N
              + ", End=" + End // NOI18N
              + super.toString(); // NOI18N
  }
}
