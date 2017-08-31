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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import static org.clang.serialization.impl.ASTWriterStatics.getDeclForLocalLookup;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;

// Trait used for the on-disk hash table used in the method pool.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3388,
 FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitE")
//</editor-fold>
public class ASTDeclContextNameLookupTrait implements MultiOnDiskHashTableGenerator.MultiEmitInfoInterface<DeclarationNameKey, std.pairUIntUInt, SmallVectorUInt, ModuleFile/*P*/>, Destructors.ClassWithDestructor {
  private final ASTWriter /*&*/ Writer;
  private final/*private*/ SmallVectorUInt DeclIDs;
/*public:*/
  // JAVA: typedef DeclarationNameKey key_type
//  public final class key_type extends DeclarationNameKey{ };
  // JAVA: typedef key_type key_type_ref
//  public final class key_type_ref extends DeclarationNameKey{ };
  
  /// A start and end index into DeclIDs, representing a sequence of decls.
  // JAVA: typedef std::pair<unsigned int, unsigned int> data_type
//  public final class data_type extends std.pairUIntUInt{ };
  // JAVA: typedef const data_type &data_type_ref
//  public final class data_type_ref extends /*const*/std.pairUIntUInt/*&*/ { };
  
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3403,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitC1ERN5clang9ASTWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitC1ERN5clang9ASTWriterE")
  //</editor-fold>
  public /*explicit*/ ASTDeclContextNameLookupTrait(final ASTWriter /*&*/ Writer) {
    // : Writer(Writer), DeclIDs() 
    //START JInit
    this./*&*/Writer=/*&*/Writer;
    this.DeclIDs = new SmallVectorUInt(64, (/*uint32_t*/int)0);
    //END JInit
  }

  
  /*template <typename Coll> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::getData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3406,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::getData", NM="Tpl__ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait7getDataERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=Tpl__ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait7getDataERKT_")
  //</editor-fold>
  public </*typename*/ Coll extends Iterable<NamedDecl /*P*/> > std.pairUIntUInt getData(final /*const*/ Coll /*&*/ Decls) {
    /*uint*/int Start = DeclIDs.size();
    for (NamedDecl /*P*/ D : Decls) {
      DeclIDs.push_back(Writer.GetDeclRef(getDeclForLocalLookup(Writer.getLangOpts(), D)));
    }
    return std.make_pair_uint_uint(Start, DeclIDs.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::ImportData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3415,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::ImportData", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait10ImportDataERKN4llvm11SmallVectorIjLj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait10ImportDataERKN4llvm11SmallVectorIjLj4EEE")
  //</editor-fold>
  @Override public final/*public*/ std.pairUIntUInt ImportData(final /*const*/SmallVectorUInt /*&*/ FromReader) {
    /*uint*/int Start = DeclIDs.size();
    for (/*uint*/int ID : FromReader)  {
      DeclIDs.push_back(ID);
    }
    return std.make_pair_uint_uint(Start, DeclIDs.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::EqualKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3422,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::EqualKey", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait8EqualKeyEN5clang13serialization18DeclarationNameKeyES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait8EqualKeyEN5clang13serialization18DeclarationNameKeyES3_")
  //</editor-fold>
  @Override public final/*public*/ boolean EqualKey(DeclarationNameKey a, DeclarationNameKey b) {
    return DeclarationNameKey.$eq_DeclarationNameKey$C(a, b);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3426,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::ComputeHash", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait11ComputeHashEN5clang13serialization18DeclarationNameKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait11ComputeHashEN5clang13serialization18DeclarationNameKeyE")
  //</editor-fold>
  @Override public final/*public*/ /*uint*/int ComputeHash(DeclarationNameKey Name) {
    return Name.getHash();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitFileRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3430,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitFileRef", NM="_ZNK12_GLOBAL__N_129ASTDeclContextNameLookupTrait11EmitFileRefERN4llvm11raw_ostreamEPN5clang13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK12_GLOBAL__N_129ASTDeclContextNameLookupTrait11EmitFileRefERN4llvm11raw_ostreamEPN5clang13serialization10ModuleFileE")
  //</editor-fold>
  @Override public final/*public*/ void EmitFileRef(final raw_ostream /*&*/ Out, ModuleFile /*P*/ F) /*const*/ {
    assert (Writer.hasChain()) : "have reference to loaded module file but no chain?";
    
    //JAVA: using namespace llvm::support;
    new Writer(little, Out).
        /*<uint32_t>*/write_uint32(Writer.getChain().getModuleFileID(F));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3439,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEN5clang13serialization18DeclarationNameKeyERKSt4pairIjjE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEN5clang13serialization18DeclarationNameKeyERKSt4pairIjjE")
  //</editor-fold>
  @Override public final/*public*/ std.pairUIntUInt EmitKeyDataLength(final raw_ostream /*&*/ Out, 
                          DeclarationNameKey Name, 
                          final /*const*/std.pairUIntUInt/*&*/ Lookup) {
    throw new UnsupportedOperationException("EmitKeyDataLength$WrapPair must be used");
  }  
  @Override public final/*public*/ /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(final raw_ostream /*&*/ Out, 
                          DeclarationNameKey Name, 
                          final /*const*/std.pairUIntUInt/*&*/ Lookup) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    /*uint*/int KeyLen = 1;
    switch (DeclarationName.NameKind.valueOf(Name.getKind())) {
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXLiteralOperatorName:
      KeyLen += 4;
      break;
     case CXXOperatorName:
      KeyLen += 1;
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
     case CXXUsingDirective:
      break;
    }
    LE./*<uint16_t>*/write_uint16($uint2ushort(KeyLen));
    
    // 4 bytes for each DeclID.
    /*uint*/int DataLen = 4 * (Lookup.second - Lookup.first);
    assert (DataLen == DataLen) : "too many decls for serialized lookup result";
    LE./*<uint16_t>*/write_uint16($uint2ushort(DataLen));
    
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitKey">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3473,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitKey", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait7EmitKeyERN4llvm11raw_ostreamEN5clang13serialization18DeclarationNameKeyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait7EmitKeyERN4llvm11raw_ostreamEN5clang13serialization18DeclarationNameKeyEj")
  //</editor-fold>
  @Override public final/*public*/ void EmitKey(final raw_ostream /*&*/ Out, DeclarationNameKey Name, /*uint*/int $Prm2) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    LE.write_uint8($uint2uchar(Name.getKind()));
    switch (DeclarationName.NameKind.valueOf(Name.getKind())) {
     case Identifier:
     case CXXLiteralOperatorName:
      LE./*<uint32_t>*/write_uint32(Writer.getIdentifierRef(Name.getIdentifier()));
      return;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      LE./*<uint32_t>*/write_uint32(Writer.getSelectorRef(Name.getSelector()));
      return;
     case CXXOperatorName:
      assert (Name.getOperatorKind().getValue() < OverloadedOperatorKind.NUM_OVERLOADED_OPERATORS.getValue()) : "Invalid operator?";
      LE./*<uint8_t>*/write_uint8($uint2uchar(Name.getOperatorKind().getValue()));
      return;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
     case CXXUsingDirective:
      return;
    }
    throw new llvm_unreachable("Invalid name kind?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3502,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::EmitData", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait8EmitDataERN4llvm11raw_ostreamEN5clang13serialization18DeclarationNameKeyESt4pairIjjEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTrait8EmitDataERN4llvm11raw_ostreamEN5clang13serialization18DeclarationNameKeyESt4pairIjjEj")
  //</editor-fold>
  @Override public final/*public*/ void EmitData(final raw_ostream /*&*/ Out, DeclarationNameKey $Prm1, std.pairUIntUInt Lookup, 
          /*uint*/int DataLen) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    long/*uint64_t*/ Start = Out.tell();
    ///*J:(void)*/Start;
    for (/*uint*/int I = Lookup.first, N = Lookup.second; I != N; ++I)  {
      LE./*<uint32_t>*/write_uint32(DeclIDs.$at(I));
    }
    assert (Out.tell() - Start == $uint2ullong(DataLen)) : "Data length is wrong";
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclContextNameLookupTrait::~ASTDeclContextNameLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3388,
   FQN="(anonymous namespace)::ASTDeclContextNameLookupTrait::~ASTDeclContextNameLookupTrait", NM="_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DeclIDs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + NativeTrace.getIdentityStr(Writer) // NOI18N
              + ", DeclIDs=" + DeclIDs; // NOI18N
  }
}
