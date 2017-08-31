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
import org.clang.serialization.*;
import org.llvm.adt.*;
import org.llvm.support.*;

/// \brief An identifier-lookup iterator that enumerates all of the
/// identifiers stored within a set of AST files.
//<editor-fold defaultstate="collapsed" desc="clang::ASTIdentifierIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7004,
 FQN="clang::ASTIdentifierIterator", NM="_ZN5clang21ASTIdentifierIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang21ASTIdentifierIteratorE")
//</editor-fold>
public class ASTIdentifierIterator extends /*public*/ IdentifierIterator implements Destructors.ClassWithDestructor {
  /// \brief The AST reader whose identifiers are being enumerated.
  private final /*const*/ ASTReader /*&*/ Reader;
  
  /// \brief The current index into the chain of AST files stored in
  /// the AST reader.
  private /*uint*/int Index;
  
  /// \brief The current position within the identifier lookup table
  /// of the current AST file.
  private OnDiskIterableChainedHashTable.key_iterator/*<ASTIdentifierLookupTrait>*/<StringRef, IdentifierInfo> Current;
  
  /// \brief The end position within the identifier lookup table of
  /// the current AST file.
  private OnDiskIterableChainedHashTable.key_iterator/*<ASTIdentifierLookupTrait>*/<StringRef, IdentifierInfo> End;
  
  /// \brief Whether to skip any modules in the ASTReader.
  private boolean SkipModules;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTIdentifierIterator::ASTIdentifierIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7031,
   FQN="clang::ASTIdentifierIterator::ASTIdentifierIterator", NM="_ZN5clang21ASTIdentifierIteratorC1ERKNS_9ASTReaderEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang21ASTIdentifierIteratorC1ERKNS_9ASTReaderEb")
  //</editor-fold>
  public ASTIdentifierIterator(final /*const*/ ASTReader /*&*/ Reader) {
    this(Reader, 
      false);
  }
  public ASTIdentifierIterator(final /*const*/ ASTReader /*&*/ Reader, 
      boolean SkipModules/*= false*/) {
    // : IdentifierIterator(), Reader(Reader), Index(Reader.ModuleMgr.size()), Current(), End(), SkipModules(SkipModules) 
    //START JInit
    super();
    this./*&*/Reader=/*&*/Reader;
    this.Index = Reader.ModuleMgr.size();
    this.Current = new OnDiskIterableChainedHashTable.key_iterator<>/*<ASTIdentifierLookupTrait>*/();
    this.End = new OnDiskIterableChainedHashTable.key_iterator<>/*<ASTIdentifierLookupTrait>*/();
    this.SkipModules = SkipModules;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTIdentifierIterator::Next">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7036,
   FQN="clang::ASTIdentifierIterator::Next", NM="_ZN5clang21ASTIdentifierIterator4NextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang21ASTIdentifierIterator4NextEv")
  //</editor-fold>
  @Override public StringRef Next()/* override*/ {
    while (OnDiskIterableChainedHashTable.iterator_base.$eq_iterator_base$C(Current, End)) {
      // If we have exhausted all of our AST files, we're done.
      if (Index == 0) {
        return new StringRef();
      }
      
      --Index;
      final ModuleFile /*&*/ F = Reader.ModuleMgr.$at(Index);
      if (SkipModules && F.isModule()) {
        continue;
      }
      
      OnDiskIterableChainedHashTable/*<ASTIdentifierLookupTrait>*/ /*P*/ IdTable = (OnDiskIterableChainedHashTable/*<ASTIdentifierLookupTrait>*/ /*P*/ )F.IdentifierLookupTable;
      // assign to have final fields in iterator_key
      Current = (IdTable.key_begin());
      End = (IdTable.key_end());
    }
    
    // We have any identifiers remaining in the current AST file; return
    // the next one.
    StringRef Result = Current.$star();
    Current.$preInc();
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTIdentifierIterator::~ASTIdentifierIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7004,
   FQN="clang::ASTIdentifierIterator::~ASTIdentifierIterator", NM="_ZN5clang21ASTIdentifierIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang21ASTIdentifierIteratorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", Index=" + Index // NOI18N
              + ", Current=" + Current // NOI18N
              + ", End=" + End // NOI18N
              + ", SkipModules=" + SkipModules // NOI18N
              + super.toString(); // NOI18N
  }
}
