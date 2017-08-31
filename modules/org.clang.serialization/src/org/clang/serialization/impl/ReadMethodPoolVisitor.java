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
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.serialization.reader.impl.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7101,
 FQN="clang::serialization::ReadMethodPoolVisitor", NM="_ZN5clang13serialization21ReadMethodPoolVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization21ReadMethodPoolVisitorE")
//</editor-fold>
public class ReadMethodPoolVisitor implements ModuleFile$Ref2Bool, Destructors.ClassWithDestructor {
  private final ASTReader /*&*/ Reader;
  private Selector Sel;
  private /*uint*/int PriorGeneration;
  private /*uint*/int InstanceBits;
  private /*uint*/int FactoryBits;
  private boolean InstanceHasMoreThanOneDecl;
  private boolean FactoryHasMoreThanOneDecl;
  private SmallVector<ObjCMethodDecl /*P*/ > InstanceMethods;
  private SmallVector<ObjCMethodDecl /*P*/ > FactoryMethods;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::ReadMethodPoolVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7113,
   FQN="clang::serialization::ReadMethodPoolVisitor::ReadMethodPoolVisitor", NM="_ZN5clang13serialization21ReadMethodPoolVisitorC1ERNS_9ASTReaderENS_8SelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization21ReadMethodPoolVisitorC1ERNS_9ASTReaderENS_8SelectorEj")
  //</editor-fold>
  public ReadMethodPoolVisitor(final ASTReader /*&*/ Reader, Selector Sel, 
      /*uint*/int PriorGeneration) {
    // : Reader(Reader), Sel(Sel), PriorGeneration(PriorGeneration), InstanceBits(0), FactoryBits(0), InstanceHasMoreThanOneDecl(false), FactoryHasMoreThanOneDecl(false), InstanceMethods(), FactoryMethods() 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this.Sel = new Selector(Sel);
    this.PriorGeneration = PriorGeneration;
    this.InstanceBits = 0;
    this.FactoryBits = 0;
    this.InstanceHasMoreThanOneDecl = false;
    this.FactoryHasMoreThanOneDecl = false;
    this.InstanceMethods = new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
    this.FactoryMethods = new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::operator()">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7119,
   FQN="clang::serialization::ReadMethodPoolVisitor::operator()", NM="_ZN5clang13serialization21ReadMethodPoolVisitorclERNS0_10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization21ReadMethodPoolVisitorclERNS0_10ModuleFileE")
  //</editor-fold>
  public boolean $call(final ModuleFile /*&*/ M) {
    ASTSelectorLookupTrait.data_type Data = null;
    try {
      if (!(M.SelectorLookupTable != null)) {
        return false;
      }
      
      // If we've already searched this module file, skip it now.
      if ($lesseq_uint(M.Generation, PriorGeneration)) {
        return true;
      }
      
      ++Reader.NumMethodPoolTableLookups;
      OnDiskChainedHashTable<Selector, Selector, ASTSelectorLookupTrait.data_type> /*P*/ PoolTable = (OnDiskChainedHashTable<Selector, Selector, ASTSelectorLookupTrait.data_type> /*P*/ )M.SelectorLookupTable;
//      OnDiskChainedHashTable.iterator<Selector, Selector, ASTSelectorLookupTrait.data_type> Pos = PoolTable.find(Sel);
//      if (Pos.$eq(PoolTable.end())) {
//        return false;
//      }
      ASTSelectorLookupTrait.data_type Pos = PoolTable.$get(Sel);
      if (Pos == null) {
        return false;
      }
      
      ++Reader.NumMethodPoolTableHits;
      ++Reader.NumSelectorsRead;
      // FIXME: Not quite happy with the statistics here. We probably should
      // disable this tracking when called via LoadSelector.
      // Also, should entries without methods count as misses?
      ++Reader.NumMethodPoolEntriesRead;
      Data = Pos/*.$star()*/;
      if ((Reader.DeserializationListener != null)) {
        Reader.DeserializationListener.SelectorRead(Data.ID, new Selector(Sel));
      }
      
      InstanceMethods.append_T(Data.Instance.begin(), Data.Instance.end());
      FactoryMethods.append_T(Data.Factory.begin(), Data.Factory.end());
      InstanceBits = Data.InstanceBits;
      FactoryBits = Data.FactoryBits;
      InstanceHasMoreThanOneDecl = Data.InstanceHasMoreThanOneDecl;
      FactoryHasMoreThanOneDecl = Data.FactoryHasMoreThanOneDecl;
      return true;
    } finally {
      if (Data != null) { Data.$destroy(); }
    }
  }

  
  /// \brief Retrieve the instance methods found by this visitor.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::getInstanceMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7154,
   FQN="clang::serialization::ReadMethodPoolVisitor::getInstanceMethods", NM="_ZNK5clang13serialization21ReadMethodPoolVisitor18getInstanceMethodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization21ReadMethodPoolVisitor18getInstanceMethodsEv")
  //</editor-fold>
  public ArrayRef<ObjCMethodDecl /*P*/ > getInstanceMethods() /*const*/ {
    return new ArrayRef<ObjCMethodDecl /*P*/ >(InstanceMethods, true);
  }

  
  /// \brief Retrieve the instance methods found by this visitor.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::getFactoryMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7159,
   FQN="clang::serialization::ReadMethodPoolVisitor::getFactoryMethods", NM="_ZNK5clang13serialization21ReadMethodPoolVisitor17getFactoryMethodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization21ReadMethodPoolVisitor17getFactoryMethodsEv")
  //</editor-fold>
  public ArrayRef<ObjCMethodDecl /*P*/ > getFactoryMethods() /*const*/ {
    return new ArrayRef<ObjCMethodDecl /*P*/ >(FactoryMethods, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::getInstanceBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7163,
   FQN="clang::serialization::ReadMethodPoolVisitor::getInstanceBits", NM="_ZNK5clang13serialization21ReadMethodPoolVisitor15getInstanceBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization21ReadMethodPoolVisitor15getInstanceBitsEv")
  //</editor-fold>
  public /*uint*/int getInstanceBits() /*const*/ {
    return InstanceBits;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::getFactoryBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7164,
   FQN="clang::serialization::ReadMethodPoolVisitor::getFactoryBits", NM="_ZNK5clang13serialization21ReadMethodPoolVisitor14getFactoryBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization21ReadMethodPoolVisitor14getFactoryBitsEv")
  //</editor-fold>
  public /*uint*/int getFactoryBits() /*const*/ {
    return FactoryBits;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::instanceHasMoreThanOneDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7165,
   FQN="clang::serialization::ReadMethodPoolVisitor::instanceHasMoreThanOneDecl", NM="_ZNK5clang13serialization21ReadMethodPoolVisitor26instanceHasMoreThanOneDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization21ReadMethodPoolVisitor26instanceHasMoreThanOneDeclEv")
  //</editor-fold>
  public boolean instanceHasMoreThanOneDecl() /*const*/ {
    return InstanceHasMoreThanOneDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::factoryHasMoreThanOneDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7168,
   FQN="clang::serialization::ReadMethodPoolVisitor::factoryHasMoreThanOneDecl", NM="_ZNK5clang13serialization21ReadMethodPoolVisitor25factoryHasMoreThanOneDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization21ReadMethodPoolVisitor25factoryHasMoreThanOneDeclEv")
  //</editor-fold>
  public boolean factoryHasMoreThanOneDecl() /*const*/ {
    return FactoryHasMoreThanOneDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ReadMethodPoolVisitor::~ReadMethodPoolVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7101,
   FQN="clang::serialization::ReadMethodPoolVisitor::~ReadMethodPoolVisitor", NM="_ZN5clang13serialization21ReadMethodPoolVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization21ReadMethodPoolVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FactoryMethods.$destroy();
    InstanceMethods.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", Sel=" + Sel // NOI18N
              + ", PriorGeneration=" + PriorGeneration // NOI18N
              + ", InstanceBits=" + InstanceBits // NOI18N
              + ", FactoryBits=" + FactoryBits // NOI18N
              + ", InstanceHasMoreThanOneDecl=" + InstanceHasMoreThanOneDecl // NOI18N
              + ", FactoryHasMoreThanOneDecl=" + FactoryHasMoreThanOneDecl // NOI18N
              + ", InstanceMethods=" + "[SmallVector$ObjCMethodDecl]" // NOI18N
              + ", FactoryMethods=" + "[SmallVector$ObjCMethodDecl]"; // NOI18N
  }
}
