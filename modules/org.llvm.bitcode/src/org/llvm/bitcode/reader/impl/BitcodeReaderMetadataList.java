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

package org.llvm.bitcode.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 107,
 FQN="(anonymous namespace)::BitcodeReaderMetadataList", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataListE")
//</editor-fold>
public class BitcodeReaderMetadataList implements Destructors.ClassWithDestructor {
  private /*uint*/int NumFwdRefs;
  private boolean AnyFwdRefs;
  private /*uint*/int MinFwdRef;
  private /*uint*/int MaxFwdRef;
  
  /// Array of metadata references.
  ///
  /// Don't use std::vector here.  Some versions of libc++ copy (instead of
  /// move) on resize, and TrackingMDRef is very expensive to copy.
  private SmallVector<TrackingMDRef> MetadataPtrs;
  
  /// Structures for resolving old type refs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 120,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::(anonymous)", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataListE_Unnamed_struct1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataListE_Unnamed_struct1")
  //</editor-fold>
  private static class/*struct*/ Unnamed_struct1 implements Destructors.ClassWithDestructor {
    public SmallDenseMap<MDString /*P*/ , std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/>> Unknown;
    public SmallDenseMap<MDString /*P*/ , DICompositeType /*P*/ > Final;
    public SmallDenseMap<MDString /*P*/ , DICompositeType /*P*/ > FwdDecls;
    public SmallVector<std.pair<TrackingMDRef, std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/> >> Arrays;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::(anonymous struct)::~">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 120,
     FQN="(anonymous namespace)::BitcodeReaderMetadataList::(anonymous struct)::~", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList3$_0D0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList3$_0D0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::(anonymous struct)::">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 120,
     FQN="(anonymous namespace)::BitcodeReaderMetadataList::(anonymous struct)::", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList3$_0C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList3$_0C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_struct1() {
      // : Unknown(), Final(), FwdDecls(), Arrays() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Unknown=" + Unknown // NOI18N
                + ", Final=" + Final // NOI18N
                + ", FwdDecls=" + FwdDecls // NOI18N
                + ", Arrays=" + Arrays; // NOI18N
    }
  };
  private Unnamed_struct1 OldTypeRefs;
  
  private LLVMContext /*&*/ Context;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::BitcodeReaderMetadataList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 129,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::BitcodeReaderMetadataList", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataListC1ERN4llvm11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataListC1ERN4llvm11LLVMContextE")
  //</editor-fold>
  public BitcodeReaderMetadataList(LLVMContext /*&*/ C) {
    // : NumFwdRefs(0), AnyFwdRefs(false), MetadataPtrs(), OldTypeRefs(), Context(C) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // vector compatibility methods
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::size">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 133,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::size", NM="_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::resize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 134,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::resize", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList6resizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList6resizeEj")
  //</editor-fold>
  public void resize(/*uint*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::push_back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 135,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::push_back", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList9push_backEPN4llvm8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList9push_backEPN4llvm8MetadataE")
  //</editor-fold>
  public void push_back(Metadata /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 136,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::clear", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 137,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::back", NM="_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList4backEv")
  //</editor-fold>
  public Metadata /*P*/ back() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::pop_back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 138,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::pop_back", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 139,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::empty", NM="_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::operator[]">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 141,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::operator[]", NM="_ZNK12_GLOBAL__N_125BitcodeReaderMetadataListixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_125BitcodeReaderMetadataListixEj")
  //</editor-fold>
  public Metadata /*P*/ $at(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::lookup">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 146,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::lookup", NM="_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList6lookupEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList6lookupEj")
  //</editor-fold>
  public Metadata /*P*/ lookup(/*uint*/int I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::shrinkTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 152,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::shrinkTo", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList8shrinkToEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList8shrinkToEj")
  //</editor-fold>
  public void shrinkTo(/*uint*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the given metadata, creating a replaceable forward reference if
  /// necessary.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::getMetadataFwdRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1112,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::getMetadataFwdRef", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList17getMetadataFwdRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList17getMetadataFwdRefEj")
  //</editor-fold>
  public Metadata /*P*/ getMetadataFwdRef(/*uint*/int Idx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the the given metadata only if it is fully resolved.
  ///
  /// Gives the same result as \a lookup(), unless \a MDNode::isResolved()
  /// would give \c false.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::getMetadataIfResolved">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1135,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::getMetadataIfResolved", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList21getMetadataIfResolvedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList21getMetadataIfResolvedEj")
  //</editor-fold>
  public Metadata /*P*/ getMetadataIfResolved(/*uint*/int Idx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::getMDNodeFwdRefOrNull">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1143,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::getMDNodeFwdRefOrNull", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList21getMDNodeFwdRefOrNullEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList21getMDNodeFwdRefOrNullEj")
  //</editor-fold>
  public MDNode /*P*/ getMDNodeFwdRefOrNull(/*uint*/int Idx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::assignValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1091,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::assignValue", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList11assignValueEPN4llvm8MetadataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList11assignValueEPN4llvm8MetadataEj")
  //</editor-fold>
  public void assignValue(Metadata /*P*/ MD, /*uint*/int Idx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::tryToResolveCycles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1147,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::tryToResolveCycles", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList18tryToResolveCyclesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList18tryToResolveCyclesEv")
  //</editor-fold>
  public void tryToResolveCycles() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::hasFwdRefs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 171,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::hasFwdRefs", NM="_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList10hasFwdRefsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_125BitcodeReaderMetadataList10hasFwdRefsEv")
  //</editor-fold>
  public boolean hasFwdRefs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Upgrade a type that had an MDString reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::addTypeRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1205,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::addTypeRef", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList10addTypeRefERN4llvm8MDStringERNS1_15DICompositeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList10addTypeRefERN4llvm8MDStringERNS1_15DICompositeTypeE")
  //</editor-fold>
  public void addTypeRef(MDString /*&*/ UUID, 
            DICompositeType /*&*/ CT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Upgrade a type that had an MDString reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::upgradeTypeRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1214,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::upgradeTypeRef", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList14upgradeTypeRefEPN4llvm8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList14upgradeTypeRefEPN4llvm8MetadataE")
  //</editor-fold>
  public Metadata /*P*/ upgradeTypeRef(Metadata /*P*/ MaybeUUID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Upgrade a type ref array that may have MDString references.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::upgradeTypeRefArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1228,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::upgradeTypeRefArray", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList19upgradeTypeRefArrayEPN4llvm8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList19upgradeTypeRefArrayEPN4llvm8MetadataE")
  //</editor-fold>
  public Metadata /*P*/ upgradeTypeRefArray(Metadata /*P*/ MaybeTuple) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::resolveTypeRefArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1245,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::resolveTypeRefArray", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataList19resolveTypeRefArrayEPN4llvm8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataList19resolveTypeRefArrayEPN4llvm8MetadataE")
  //</editor-fold>
  private Metadata /*P*/ resolveTypeRefArray(Metadata /*P*/ MaybeTuple) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderMetadataList::~BitcodeReaderMetadataList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 107,
   FQN="(anonymous namespace)::BitcodeReaderMetadataList::~BitcodeReaderMetadataList", NM="_ZN12_GLOBAL__N_125BitcodeReaderMetadataListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_125BitcodeReaderMetadataListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "NumFwdRefs=" + NumFwdRefs // NOI18N
              + ", AnyFwdRefs=" + AnyFwdRefs // NOI18N
              + ", MinFwdRef=" + MinFwdRef // NOI18N
              + ", MaxFwdRef=" + MaxFwdRef // NOI18N
              + ", MetadataPtrs=" + MetadataPtrs // NOI18N
              + ", OldTypeRefs=" + OldTypeRefs // NOI18N
              + ", Context=" + Context; // NOI18N
  }
}
