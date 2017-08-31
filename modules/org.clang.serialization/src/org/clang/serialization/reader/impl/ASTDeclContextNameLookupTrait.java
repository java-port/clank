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

package org.clang.serialization.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.serialization.*;
import org.clang.serialization.impl.MultiOnDiskHashTable;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import static org.clank.support.NativeType.sizeof$uint32;
import org.llvm.support.llvm.support;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// \brief Class that performs name lookup into a DeclContext stored
/// in an AST file.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 41,
 FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitE")
//</editor-fold>
public class ASTDeclContextNameLookupTrait implements MultiOnDiskHashTable.MultiInfoInterface<DeclarationName, DeclarationNameKey, SmallVectorUInt, ASTDeclContextNameLookupTrait.data_type_builder> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ F;
/*public:*/
  // Maximum number of lookup tables we allow before condensing the tables.
  public static /*const*/int MaxTables = 4;

  /// The lookup result is a list of global declaration IDs.
  // JAVA: typedef llvm::SmallVector<DeclID, 4> data_type
//  public final class data_type extends SmallVectorUInt{ };
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 51,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builderE")
  //</editor-fold>
  public static class/*struct*/ data_type_builder implements Destructors.ClassWithDestructor, MultiOnDiskHashTable.MultiInfoInterface.DataTypeBuilder<SmallVectorUInt> {
    public final SmallVectorUInt /*&*/ Data;
    public DenseSetUInt Found;
    
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder::data_type_builder">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 55,
     FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder::data_type_builder", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builderC1ERN4llvm11SmallVectorIjLj4EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builderC1ERN4llvm11SmallVectorIjLj4EEE")
    //</editor-fold>
    public data_type_builder(final SmallVectorUInt /*&*/ D) {
      // : Data(D), Found() 
      //START JInit
      this./*&*/Data=/*&*/D;
      this.Found = new DenseSetUInt(DenseMapInfoUInt.$Info());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder::insert">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 56,
     FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder::insert", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builder6insertEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builder6insertEj")
    //</editor-fold>
    public void insert(/*uint32_t*/int ID) {
      // Just use a linear scan unless we have more than a few IDs.
      if (Found.empty() && !Data.empty()) {
        if ($lesseq_uint(Data.size(), 4)) {
          for (/*uint*/int I : Found)  {
            if (I == ID) {
              return;
            }
          }
          Data.push_back(ID);
          return;
        }
        
        // Switch to tracking found IDs in the set.
        Found.insert$T(Data.begin(), Data.end());
      }
      if (Found.insert(ID).second) {
        Data.push_back(ID);
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder::~data_type_builder">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 51,
     FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::data_type_builder::~data_type_builder", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17data_type_builderD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Found.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Data=" + Data // NOI18N
                + ", Found=" + Found; // NOI18N
    }
  };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  // JAVA: typedef ModuleFile *file_type
//  public final class file_type extends ModuleFile /*P*/ { };
  
  // JAVA: typedef DeclarationName external_key_type
//  public final class external_key_type extends DeclarationName{ };
  // JAVA: typedef DeclarationNameKey internal_key_type
//  public final class internal_key_type extends DeclarationNameKey{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 82,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitC1ERNS_9ASTReaderERNS0_10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitC1ERNS_9ASTReaderERNS0_10ModuleFileE")
  //</editor-fold>
  public /*explicit*/ ASTDeclContextNameLookupTrait(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ F) {
    // : Reader(Reader), F(F) 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this./*&*/F=/*&*/F;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::EqualKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 85,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::EqualKey", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait8EqualKeyERKNS0_18DeclarationNameKeyES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait8EqualKeyERKNS0_18DeclarationNameKeyES5_")
  //</editor-fold>
  @Override
  public boolean EqualKey(final /*const*/ DeclarationNameKey /*&*/ a, final /*const*/ DeclarationNameKey /*&*/ b) {
    return DeclarationNameKey.$eq_DeclarationNameKey$C(a, b);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 89,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ComputeHash", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait11ComputeHashERKNS0_18DeclarationNameKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait11ComputeHashERKNS0_18DeclarationNameKeyE")
  //</editor-fold>
  @Override
  public /*uint*/int ComputeHash(final /*const*/ DeclarationNameKey /*&*/ Key) {
    return Key.getHash();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::GetInternalKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 92,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::GetInternalKey", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait14GetInternalKeyERKNS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait14GetInternalKeyERKNS_15DeclarationNameE")
  //</editor-fold>
  @Override
  public DeclarationNameKey GetInternalKey(final /*const*/ DeclarationName /*&*/ Name) {
    return new DeclarationNameKey(new DeclarationName(Name));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 931,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadKeyDataLength", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17ReadKeyDataLengthERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait17ReadKeyDataLengthERPKh")
  //</editor-fold>
  @Override public final /*std.pair<uint, uint>*/long ReadKeyDataLength(final char$ptr/*const uchar P&*/ Buf, int OffsetInBuf) {
    //JAVA: using namespace llvm::support;
    /*uint*/int KeyLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
                        OffsetInBuf += NativeType.sizeof$uint16();
    /*uint*/int DataLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }
  @Override public final /*uint*/int getReadKeyDataLengthBytes() {
    return NativeType.sizeof$uint16() + NativeType.sizeof$uint16();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 939,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadKey", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait7ReadKeyEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait7ReadKeyEPKhj")
  //</editor-fold>
  @Override public final DeclarationNameKey ReadKey(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, /*uint*/int $Prm1) {
    //JAVA: using namespace llvm::support;
    
    DeclarationName.NameKind Kind = DeclarationName.NameKind.valueOf(Buf.$at(OffsetInBuf++));
    Object/*uint64_t*/ Data = 0;
    switch (Kind) {
     case Identifier:
      Data = Reader.getLocalIdentifier(F, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf)); 
                                          OffsetInBuf += NativeType.sizeof$uint32();
      break;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      Data
         = Reader.getLocalSelector(F, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf)).getAsOpaquePtr();
                                          OffsetInBuf += NativeType.sizeof$uint32();
      break;
     case CXXOperatorName:
      Data = Integer.valueOf($uchar2uint(Buf.$at(OffsetInBuf++))); // OverloadedOperatorKind
      break;
     case CXXLiteralOperatorName:
      Data = Reader.getLocalIdentifier(F, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                          OffsetInBuf += NativeType.sizeof$uint32();
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
     case CXXUsingDirective:
      Data = null;
      break;
    }
    
    return new DeclarationNameKey(Kind.getValue(), Data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadDataInto">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 976,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadDataInto", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait12ReadDataIntoENS0_18DeclarationNameKeyEPKhjRNS2_17data_type_builderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait12ReadDataIntoENS0_18DeclarationNameKeyEPKhjRNS2_17data_type_builderE")
  //</editor-fold>
  @Override public final void ReadDataInto(DeclarationNameKey $Prm0, 
              /*const*/char$ptr/*uchar P*/ Buf, int DataOffsetInBuf, 
              /*uint*/int DataLen, 
              final data_type_builder /*&*/ Val) {
    //JAVA: using namespace llvm::support;
    for (/*uint*/int NumDecls = $div_uint(DataLen, 4); (NumDecls != 0); --NumDecls) {
      /*uint32_t*/int LocalID = endian.read_uint32(endianness.little, support.unaligned, Buf, DataOffsetInBuf);
                                /*JAVA:split by read and shift*/DataOffsetInBuf += sizeof$uint32();
      Val.insert(Reader.getGlobalDeclID(F, LocalID));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::MergeDataInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 104,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::MergeDataInto", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait13MergeDataIntoERKN4llvm11SmallVectorIjLj4EEERNS2_17data_type_builderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait13MergeDataIntoERKN4llvm11SmallVectorIjLj4EEERNS2_17data_type_builderE")
  //</editor-fold>
  @Override public final void MergeDataInto(final /*const*/SmallVectorUInt /*&*/ From, final data_type_builder /*&*/ To) {
    To.Data.reserve(To.Data.size() + From.size());
    for (/*uint32_t*/int ID : From)  {
      To.insert(ID);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadFileRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 924,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ReadFileRef", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait11ReadFileRefERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTrait11ReadFileRefERPKh")
  //</editor-fold>
  @Override public final ModuleFile /*P*/ ReadFileRef(final char$ptr/*const uchar P&*/ d) {
    //JAVA: using namespace llvm::support;
    /*uint32_t*/int ModuleFileID = endian.readNext_uint32(endianness.little, support.unaligned, d);
    return Reader.getLocalModuleFile(F, ModuleFileID);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 41,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ASTDeclContextNameLookupTrait(final /*const*/ ASTDeclContextNameLookupTrait /*&*/ $Prm0) {
    // : Reader(.Reader), F(.F) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/F=/*&*/$Prm0.F;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 41,
   FQN="clang::serialization::reader::ASTDeclContextNameLookupTrait::ASTDeclContextNameLookupTrait", NM="_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitC1EOS2_")
  //</editor-fold>
  public /*inline*/ ASTDeclContextNameLookupTrait(JD$Move _dparam, final ASTDeclContextNameLookupTrait /*&&*/$Prm0) {
    // : Reader(static_cast<ASTDeclContextNameLookupTrait &&>().Reader), F(static_cast<ASTDeclContextNameLookupTrait &&>().F) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/F=/*&*/$Prm0.F;
    //END JInit
  }

  public ASTDeclContextNameLookupTrait() {
    this.Reader = null;
    this.F = null;
  }
  
  @Override public data_type_builder new$data_type_builder(SmallVectorUInt data) {
    return new data_type_builder(data);
  }

  @Override public SmallVectorUInt new$data_type() {
    return new SmallVectorUInt(0);
  }

  @Override public /*uint*/int $MaxTables() {
    return MaxTables;
  }
  
  @Override public String toString() {
    return "" + "Reader=" + NativeTrace.getIdentityStr(Reader) // NOI18N
              + ", F=" + NativeTrace.getIdentityStr(F); // NOI18N
  }
}
