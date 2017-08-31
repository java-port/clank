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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;


/// Holds a subclass of DINode.
///
/// FIXME: This class doesn't currently make much sense.  Previously it was a
/// union beteen MDString (for ODR-uniqued types) and things like DIType.  To
/// support CodeView work, it wasn't deleted outright when MDString-based type
/// references were deleted; we'll soon need a similar concept for CodeView
/// DITypeIndex.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 55,
 FQN="llvm::TypedDINodeRef", NM="_ZN4llvm14TypedDINodeRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14TypedDINodeRefE")
//</editor-fold>
public class TypedDINodeRef</*class*/ T>  implements Native.NativeComparable<TypedDINodeRef> {
  private /*const*/ Metadata /*P*/ MD/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::TypedDINodeRef<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 59,
   FQN="llvm::TypedDINodeRef::TypedDINodeRef<T>", NM="_ZN4llvm14TypedDINodeRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14TypedDINodeRefC1Ev")
  //</editor-fold>
  public TypedDINodeRef()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::TypedDINodeRef<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 60,
   FQN="llvm::TypedDINodeRef::TypedDINodeRef<T>", NM="_ZN4llvm14TypedDINodeRefC1EDn",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14TypedDINodeRefC1EDn")
  //</editor-fold>
  /*friend*/public TypedDINodeRef(Class<T> cls, JD$NullPtr _dparam, /*nullptr_t*/Object $Prm0) {
    assert $Prm0 == null;
    this.cls = cls;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::TypedDINodeRef<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 61,
   FQN="llvm::TypedDINodeRef::TypedDINodeRef<T>", NM="_ZN4llvm14TypedDINodeRefC1EPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14TypedDINodeRefC1EPKT_")
  //</editor-fold>
  public TypedDINodeRef(Class<T> cls, /*const*/ T /*P*/ MD) {
    // : MD(MD) 
    //START JInit
    this.cls = cls;
    this.MD = /*ParenListExpr*/(DINode)MD;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::TypedDINodeRef<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 63,
   FQN="llvm::TypedDINodeRef::TypedDINodeRef<T>", NM="_ZN4llvm14TypedDINodeRefC1EPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14TypedDINodeRefC1EPKNS_8MetadataE")
  //</editor-fold>
  public /*explicit*/ TypedDINodeRef(Class<T> cls, /*const*/ Metadata /*P*/ MD) {
    // : MD(MD) 
    //START JInit
    this.cls = cls;
    this.MD = MD;
    //END JInit
    assert Native.$bool((!(MD != null) || isa(cls, MD))) : "Expected valid type ref";
  }

  
  /*template <class U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::TypedDINodeRef<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 68,
   FQN="llvm::TypedDINodeRef::TypedDINodeRef<T>", NM="Tpl__ZN4llvm14TypedDINodeRefC1ERKNS_14TypedDINodeRefIT_EEPNSt9enable_ifIXsr14is_convertibleIPS2_PT_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=Tpl__ZN4llvm14TypedDINodeRefC1ERKNS_14TypedDINodeRefIT_EEPNSt9enable_ifIXsr14is_convertibleIPS2_PT_EE5valueEvE4typeE")
  //</editor-fold>
  public </*class*/ U> TypedDINodeRef(Class<T> cls, JD$Convertible _dparam, final /*const*/ TypedDINodeRef<U> /*&*/ X) {
    // : MD(X) 
    //START JInit
    this.cls = cls;
    this.MD = /*ParenListExpr*/X.$Metadata$P();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::operator Metadata * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 74,
   FQN="llvm::TypedDINodeRef::operator Metadata * ", NM="_ZNK4llvm14TypedDINodeRefcvPNS_8MetadataEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14TypedDINodeRefcvPNS_8MetadataEEv")
  //</editor-fold>
  public Metadata /*P*/ $Metadata$P() /*const*/ {
    return ((/*const_cast*/Metadata /*P*/ )(MD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::resolve">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 76,
   FQN="llvm::TypedDINodeRef::resolve", NM="_ZNK4llvm14TypedDINodeRef7resolveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14TypedDINodeRef7resolveEv")
  //</editor-fold>
  public T /*P*/ resolve() /*const*/ {
    return ((/*const_cast*/T /*P*/ )(cast_or_null(cls, MD)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 78,
   FQN="llvm::TypedDINodeRef::operator==", NM="_ZNK4llvm14TypedDINodeRefeqERKNS_14TypedDINodeRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14TypedDINodeRefeqERKNS_14TypedDINodeRefIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ TypedDINodeRef<T> /*&*/ X) /*const*/ {
    return Native.$eq(MD, X.MD);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedDINodeRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 79,
   FQN="llvm::TypedDINodeRef::operator!=", NM="_ZNK4llvm14TypedDINodeRefneERKNS_14TypedDINodeRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14TypedDINodeRefneERKNS_14TypedDINodeRefIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ TypedDINodeRef<T> /*&*/ X) /*const*/ {
    return Native.$noteq(MD, X.MD);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final Class<T> cls;

  public TypedDINodeRef(TypedDINodeRef<T> other) {
    this.cls = other.cls;
    this.MD = new Metadata(other.MD);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "MD=" + MD; // NOI18N
  }
}
