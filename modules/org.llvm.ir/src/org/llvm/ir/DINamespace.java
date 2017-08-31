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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;

//<editor-fold defaultstate="collapsed" desc="llvm::DINamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1599,
 FQN="llvm::DINamespace", NM="_ZN4llvm11DINamespaceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespaceE")
//</editor-fold>
public class DINamespace extends /*public*/ DIScope implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::DINamespace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1605,
   FQN="llvm::DINamespace::DINamespace", NM="_ZN4llvm11DINamespaceC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespaceC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DINamespace(final LLVMContext /*&*/ Context, Metadata.StorageType Storage, /*uint*/int Line,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DIScope(Context, DINamespaceKind, Storage, dwarf::DW_TAG_namespace, Ops), Line(Line)
    //START JInit
    super(Context, MetadataKind.DINamespaceKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_namespace),
        new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::~DINamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1610,
   FQN="llvm::DINamespace::~DINamespace", NM="_ZN4llvm11DINamespaceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11DINamespaceD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1612,
   FQN="llvm::DINamespace::getImpl", NM="_ZN4llvm11DINamespace7getImplERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEjNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace7getImplERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEjNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DINamespace /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope,
         DIFile /*P*/ File, StringRef Name, /*uint*/int Line,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         File, Name, Line,
         Storage, true);
  }
  private static DINamespace /*P*/ getImpl(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope,
         DIFile /*P*/ File, StringRef Name, /*uint*/int Line,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    return getImpl(Context, Scope, File, DINode.getCanonicalMDString(Context, new StringRef(Name)),
        Line, Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 468,
   FQN="llvm::DINamespace::getImpl", NM="_ZN4llvm11DINamespace7getImplERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEjNS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace7getImplERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEjNS3_11StorageTypeEb")
  //</editor-fold>
  private static DINamespace /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         Metadata /*P*/ File, MDString /*P*/ Name, /*uint*/int Line,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         File, Name, Line,
         Storage, true);
  }
  private static DINamespace /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         Metadata /*P*/ File, MDString /*P*/ Name, /*uint*/int Line,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DINamespace /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DINamespaces, new MDNodeKeyImplDINamespace(Scope, File, Name, Line));
          if ((N != null)) {
            return N;
          }
        }
        if (!ShouldCreate) {
          return null;
        }
      } else {
        assert (ShouldCreate) : "Expected non-uniqued nodes to always be created";
      }
    } while (false);
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {File, Scope, Name};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DINamespace(Context, Storage, Line, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DINamespaces);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1622,
   FQN="llvm::DINamespace::cloneImpl", NM="_ZNK4llvm11DINamespace9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DINamespace /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DINamespace.getTemporary(getContext(), getScope(), getFile(), getName(),
        getLine());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1628,
   FQN="llvm::DINamespace::get", NM="_ZN4llvm11DINamespace3getERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace3getERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj")
  //</editor-fold>
  public static DINamespace /*P*/ get(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, DIFile /*P*/ File, StringRef Name, /*uint*/int Line) {
    return DINamespace.getImpl(Context, Scope, File, new StringRef(Name), Line, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1628,
   FQN="llvm::DINamespace::getIfExists", NM="_ZN4llvm11DINamespace11getIfExistsERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace11getIfExistsERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj")
  //</editor-fold>
  public static DINamespace /*P*/ getIfExists(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, DIFile /*P*/ File, StringRef Name, /*uint*/int Line) {
    return DINamespace.getImpl(Context, Scope, File, new StringRef(Name), Line, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1628,
   FQN="llvm::DINamespace::getDistinct", NM="_ZN4llvm11DINamespace11getDistinctERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace11getDistinctERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj")
  //</editor-fold>
  public static DINamespace /*P*/ getDistinct(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, DIFile /*P*/ File, StringRef Name, /*uint*/int Line) {
    return DINamespace.getImpl(Context, Scope, File, new StringRef(Name), Line, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1628,
   FQN="llvm::DINamespace::getTemporary", NM="_ZN4llvm11DINamespace12getTemporaryERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace12getTemporaryERNS_11LLVMContextEPNS_7DIScopeEPNS_6DIFileENS_9StringRefEj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DINamespace /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, DIScope /*P*/ Scope, DIFile /*P*/ File, StringRef Name, /*uint*/int Line) {
    return new std.unique_ptr_with_deleter<DINamespace /*, TempMDNodeDeleter*/>(DINamespace.getImpl(Context, Scope, File, new StringRef(Name), Line, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1631,
   FQN="llvm::DINamespace::get", NM="_ZN4llvm11DINamespace3getERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace3getERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj")
  //</editor-fold>
  public static DINamespace /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, MDString /*P*/ Name, /*uint*/int Line) {
    return getImpl(Context, Scope, File, Name, Line, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1631,
   FQN="llvm::DINamespace::getIfExists", NM="_ZN4llvm11DINamespace11getIfExistsERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace11getIfExistsERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj")
  //</editor-fold>
  public static DINamespace /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, MDString /*P*/ Name, /*uint*/int Line) {
    return getImpl(Context, Scope, File, Name, Line, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1631,
   FQN="llvm::DINamespace::getDistinct", NM="_ZN4llvm11DINamespace11getDistinctERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace11getDistinctERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj")
  //</editor-fold>
  public static DINamespace /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, MDString /*P*/ Name, /*uint*/int Line) {
    return getImpl(Context, Scope, File, Name, Line, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1631,
   FQN="llvm::DINamespace::getTemporary", NM="_ZN4llvm11DINamespace12getTemporaryERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace12getTemporaryERNS_11LLVMContextEPNS_8MetadataES4_PNS_8MDStringEj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DINamespace /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, MDString /*P*/ Name, /*uint*/int Line) {
    return new std.unique_ptr_with_deleter<DINamespace /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, File, Name, Line, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1635,
   FQN="llvm::DINamespace::clone", NM="_ZNK4llvm11DINamespace5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DINamespace /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1637,
   FQN="llvm::DINamespace::getLine", NM="_ZNK4llvm11DINamespace7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1638,
   FQN="llvm::DINamespace::getScope", NM="_ZNK4llvm11DINamespace8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace8getScopeEv")
  //</editor-fold>
  public DIScope /*P*/ getScope() /*const*/ {
    return cast_or_null_DIScope(getRawScope());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1639,
   FQN="llvm::DINamespace::getName", NM="_ZNK4llvm11DINamespace7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1641,
   FQN="llvm::DINamespace::getRawScope", NM="_ZNK4llvm11DINamespace11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(1).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1642,
   FQN="llvm::DINamespace::getRawName", NM="_ZNK4llvm11DINamespace10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DINamespace10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DINamespace::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1644,
   FQN="llvm::DINamespace::classof", NM="_ZN4llvm11DINamespace7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DINamespace7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DINamespaceKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + super.toString(); // NOI18N
  }
}
