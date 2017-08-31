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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.llvm.pass.IrLlvmGlobals.*;


/// CGRecordLayout - This class handles struct and union layout info while
/// lowering AST types to LLVM types.
///
/// These layout objects are only created on demand as IR generation requires.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 109,
 FQN="clang::CodeGen::CGRecordLayout", NM="_ZN5clang7CodeGen14CGRecordLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN5clang7CodeGen14CGRecordLayoutE")
//</editor-fold>
public class CGRecordLayout implements Destructors.ClassWithDestructor {
  /*friend  class CodeGenTypes*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::CGRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 112,
   FQN="clang::CodeGen::CGRecordLayout::CGRecordLayout", NM="_ZN5clang7CodeGen14CGRecordLayoutC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN5clang7CodeGen14CGRecordLayoutC1ERKS1_")
  //</editor-fold>
  protected/*private*/ CGRecordLayout(final /*const*/ CGRecordLayout /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 113,
   FQN="clang::CodeGen::CGRecordLayout::operator=", NM="_ZN5clang7CodeGen14CGRecordLayoutaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN5clang7CodeGen14CGRecordLayoutaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ CGRecordLayout /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*private:*/
  /// The LLVM type corresponding to this record layout; used when
  /// laying it out as a complete object.
  private StructType /*P*/ CompleteObjectType;
  
  /// The LLVM type for the non-virtual part of this record layout;
  /// used when laying it out as a base subobject.
  private StructType /*P*/ BaseSubobjectType;
  
  /// Map from (non-bit-field) struct field to the corresponding llvm struct
  /// type field no. This info is populated by record builder.
  /*friend*//*private*/ DenseMapTypeUInt</*const*/ FieldDecl /*P*/ > FieldInfo;
  
  /// Map from (bit-field) struct field to the corresponding llvm struct type
  /// field no. This info is populated by record builder.
  /*friend*//*private*/ DenseMap</*const*/ FieldDecl /*P*/ , CGBitFieldInfo> BitFields;
  
  // FIXME: Maybe we could use a CXXBaseSpecifier as the key and use a single
  // map for both virtual and non-virtual bases.
  /*friend*//*private*/ DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > NonVirtualBases;
  
  /// Map from virtual bases to their field index in the complete object.
  /*friend*//*private*/ DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > CompleteObjectVirtualBases;
  
  /// False if any direct or indirect subobject of this class, when
  /// considered as a complete object, requires a non-zero bitpattern
  /// when zero-initialized.
  private /*JBIT bool*/ boolean IsZeroInitializable /*: 1*/;
  
  /// False if any direct or indirect subobject of this class, when
  /// considered as a base subobject, requires a non-zero bitpattern
  /// when zero-initialized.
  private /*JBIT bool*/ boolean IsZeroInitializableAsBase /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::CGRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 150,
   FQN="clang::CodeGen::CGRecordLayout::CGRecordLayout", NM="_ZN5clang7CodeGen14CGRecordLayoutC1EPN4llvm10StructTypeES4_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN5clang7CodeGen14CGRecordLayoutC1EPN4llvm10StructTypeES4_bb")
  //</editor-fold>
  public CGRecordLayout(StructType /*P*/ CompleteObjectType, 
      StructType /*P*/ BaseSubobjectType, 
      boolean IsZeroInitializable, 
      boolean IsZeroInitializableAsBase) {
    // : CompleteObjectType(CompleteObjectType), BaseSubobjectType(BaseSubobjectType), FieldInfo(), BitFields(), NonVirtualBases(), CompleteObjectVirtualBases(), IsZeroInitializable(IsZeroInitializable), IsZeroInitializableAsBase(IsZeroInitializableAsBase) 
    //START JInit
    this.CompleteObjectType = CompleteObjectType;
    this.BaseSubobjectType = BaseSubobjectType;
    this.FieldInfo = new DenseMapTypeUInt</*const*/ FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.BitFields = new DenseMap</*const*/ FieldDecl /*P*/ , CGBitFieldInfo>(DenseMapInfo$LikePtr.$Info(), new CGBitFieldInfo());
    this.NonVirtualBases = new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.CompleteObjectVirtualBases = new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.IsZeroInitializable = IsZeroInitializable;
    this.IsZeroInitializableAsBase = IsZeroInitializableAsBase;
    //END JInit
  }

  
  /// \brief Return the "complete object" LLVM type associated with
  /// this record.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::getLLVMType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 161,
   FQN="clang::CodeGen::CGRecordLayout::getLLVMType", NM="_ZNK5clang7CodeGen14CGRecordLayout11getLLVMTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout11getLLVMTypeEv")
  //</editor-fold>
  public StructType /*P*/ getLLVMType() /*const*/ {
    return CompleteObjectType;
  }

  
  /// \brief Return the "base subobject" LLVM type associated with
  /// this record.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::getBaseSubobjectLLVMType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 167,
   FQN="clang::CodeGen::CGRecordLayout::getBaseSubobjectLLVMType", NM="_ZNK5clang7CodeGen14CGRecordLayout24getBaseSubobjectLLVMTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout24getBaseSubobjectLLVMTypeEv")
  //</editor-fold>
  public StructType /*P*/ getBaseSubobjectLLVMType() /*const*/ {
    return BaseSubobjectType;
  }

  
  /// \brief Check whether this struct can be C++ zero-initialized
  /// with a zeroinitializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 173,
   FQN="clang::CodeGen::CGRecordLayout::isZeroInitializable", NM="_ZNK5clang7CodeGen14CGRecordLayout19isZeroInitializableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout19isZeroInitializableEv")
  //</editor-fold>
  public boolean isZeroInitializable() /*const*/ {
    return IsZeroInitializable;
  }

  
  /// \brief Check whether this struct can be C++ zero-initialized
  /// with a zeroinitializer when considered as a base subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::isZeroInitializableAsBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 179,
   FQN="clang::CodeGen::CGRecordLayout::isZeroInitializableAsBase", NM="_ZNK5clang7CodeGen14CGRecordLayout25isZeroInitializableAsBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout25isZeroInitializableAsBaseEv")
  //</editor-fold>
  public boolean isZeroInitializableAsBase() /*const*/ {
    return IsZeroInitializableAsBase;
  }

  
  /// \brief Return llvm::StructType element number that corresponds to the
  /// field FD.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::getLLVMFieldNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 185,
   FQN="clang::CodeGen::CGRecordLayout::getLLVMFieldNo", NM="_ZNK5clang7CodeGen14CGRecordLayout14getLLVMFieldNoEPKNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout14getLLVMFieldNoEPKNS_9FieldDeclE")
  //</editor-fold>
  public /*uint*/int getLLVMFieldNo(/*const*/ FieldDecl /*P*/ FD) /*const*/ {
    FD = FD.getCanonicalDecl$Const();
    assert ((FieldInfo.count(FD) != 0)) : "Invalid field for record!";
    return FieldInfo.lookup(FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::getNonVirtualBaseLLVMFieldNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 191,
   FQN="clang::CodeGen::CGRecordLayout::getNonVirtualBaseLLVMFieldNo", NM="_ZNK5clang7CodeGen14CGRecordLayout28getNonVirtualBaseLLVMFieldNoEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout28getNonVirtualBaseLLVMFieldNoEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*uint*/int getNonVirtualBaseLLVMFieldNo(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    assert ((NonVirtualBases.count(RD) != 0)) : "Invalid non-virtual base!";
    return NonVirtualBases.lookup(RD);
  }

  
  /// \brief Return the LLVM field index corresponding to the given
  /// virtual base.  Only valid when operating on the complete object.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::getVirtualBaseIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 198,
   FQN="clang::CodeGen::CGRecordLayout::getVirtualBaseIndex", NM="_ZNK5clang7CodeGen14CGRecordLayout19getVirtualBaseIndexEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout19getVirtualBaseIndexEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*uint*/int getVirtualBaseIndex(/*const*/ CXXRecordDecl /*P*/ base) /*const*/ {
    assert ((CompleteObjectVirtualBases.count(base) != 0)) : "Invalid virtual base!";
    return CompleteObjectVirtualBases.lookup(base);
  }

  
  /// \brief Return the BitFieldInfo that corresponds to the field FD.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::getBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 204,
   FQN="clang::CodeGen::CGRecordLayout::getBitFieldInfo", NM="_ZNK5clang7CodeGen14CGRecordLayout15getBitFieldInfoEPKNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout15getBitFieldInfoEPKNS_9FieldDeclE")
  //</editor-fold>
  public /*const*/ CGBitFieldInfo /*&*/ getBitFieldInfo(/*const*/ FieldDecl /*P*/ FD) /*const*/ {
    FD = FD.getCanonicalDecl$Const();
    assert (FD.isBitField()) : "Invalid call for non-bit-field decl!";
    DenseMapIterator</*const*/ FieldDecl /*P*/ , CGBitFieldInfo> it = BitFields.find$Const(FD);
    assert (it.$noteq(BitFields.end$Const())) : "Unable to find bitfield info";
    return it.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 815,
   FQN="clang::CodeGen::CGRecordLayout::print", NM="_ZNK5clang7CodeGen14CGRecordLayout5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    std.vector<std.pairUIntType</*const*/ CGBitFieldInfo /*P*/ >> BFIs = null;
    try {
      OS.$out(/*KEEP_STR*/"<CGRecordLayout\n");
      $out_raw_ostream_Type(OS.$out(/*KEEP_STR*/"  LLVMType:"), /*Deref*/CompleteObjectType).$out(/*KEEP_STR*/$LF);
      if ((BaseSubobjectType != null)) {
        $out_raw_ostream_Type(OS.$out(/*KEEP_STR*/"  NonVirtualBaseLLVMType:"), /*Deref*/BaseSubobjectType).$out(/*KEEP_STR*/$LF);
      }
      OS.$out(/*KEEP_STR*/"  IsZeroInitializable:").$out_int((IsZeroInitializable ? 1 : 0)).$out(/*KEEP_STR*/$LF);
      OS.$out(/*KEEP_STR*/"  BitFields:[\n");
      
      // Print bit-field infos in declaration order.
      BFIs/*J*/= new std.vector<std.pairUIntType</*const*/ CGBitFieldInfo /*P*/ >>(new std.pairUIntPtr</*const*/ CGBitFieldInfo /*P*/ >());
      for (DenseMapIterator</*const*/ FieldDecl /*P*/ , CGBitFieldInfo> it = BitFields.begin$Const(), ie = BitFields.end$Const();
           it.$noteq(ie); it.$preInc()) {
        /*const*/ RecordDecl /*P*/ RD = it.$arrow().first.getParent$Const();
        /*uint*/int Index = 0;
        for (specific_decl_iterator<FieldDecl> it2 = RD.field_begin(); it2.$star() != it.$arrow().first; it2.$preInc())  {
          ++Index;
        }
        BFIs.push_back_T$RR(std.make_pair_uint_Ptr(Index, /*AddrOf*/it.$arrow().second));
      }
      llvm.array_pod_sort(BFIs.begin().toPointer(), BFIs.end().toPointer());
      for (/*uint*/int i = 0, e = BFIs.size(); i != e; ++i) {
        OS.indent(4);
        BFIs.$at(i).second.print(OS);
        OS.$out(/*KEEP_STR*/$LF);
      }
      
      OS.$out(/*KEEP_STR*/"]>\n");
    } finally {
      if (BFIs != null) { BFIs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 845,
   FQN="clang::CodeGen::CGRecordLayout::dump", NM="_ZNK5clang7CodeGen14CGRecordLayout4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGRecordLayout4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGRecordLayout::~CGRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 109,
   FQN="clang::CodeGen::CGRecordLayout::~CGRecordLayout", NM="_ZN5clang7CodeGen14CGRecordLayoutD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen14CGRecordLayoutD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CompleteObjectVirtualBases.$destroy();
    NonVirtualBases.$destroy();
    BitFields.$destroy();
    FieldInfo.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "CompleteObjectType=" + CompleteObjectType // NOI18N
              + ", BaseSubobjectType=" + BaseSubobjectType // NOI18N
              + ", FieldInfo=" + "[DenseMapTypeUInt$FieldDecl]" // NOI18N
              + ", BitFields=" + BitFields // NOI18N
              + ", NonVirtualBases=" + "[DenseMapTypeUInt$CXXRecordDecl]" // NOI18N
              + ", CompleteObjectVirtualBases=" + "[DenseMapTypeUInt$CXXRecordDecl]" // NOI18N
              + ", IsZeroInitializable=" + IsZeroInitializable // NOI18N
              + ", IsZeroInitializableAsBase=" + IsZeroInitializableAsBase; // NOI18N
  }
}
