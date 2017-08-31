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
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.serialization.impl.SerializationStatics;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import org.llvm.support.OnDiskChainedHashTable.InfoInterface;
import org.llvm.support.llvm;
import org.llvm.support.llvm.support;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// \brief Class that performs lookup for a selector's entries in the global
/// method pool stored in an AST file.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 197,
 FQN="clang::serialization::reader::ASTSelectorLookupTrait", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTraitE")
//</editor-fold>
public class ASTSelectorLookupTrait implements InfoInterface<Selector, Selector, ASTSelectorLookupTrait.data_type> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ F;

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::data_type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 202,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::data_type", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeE")
  //</editor-fold>
  public static class/*struct*/ data_type implements Destructors.ClassWithDestructor {
    public /*uint32_t*/int ID;
    public /*uint*/int InstanceBits;
    public /*uint*/int FactoryBits;
    public boolean InstanceHasMoreThanOneDecl;
    public boolean FactoryHasMoreThanOneDecl;
    public SmallVector<ObjCMethodDecl /*P*/ > Instance;
    public SmallVector<ObjCMethodDecl /*P*/ > Factory;
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::data_type::data_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 202,
     FQN="clang::serialization::reader::ASTSelectorLookupTrait::data_type::data_type", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeC1EOS3_")
    //</editor-fold>
    public /*inline*/ data_type(JD$Move _dparam, final data_type /*&&*/$Prm0) {
      // : ID(static_cast<data_type &&>().ID), InstanceBits(static_cast<data_type &&>().InstanceBits), FactoryBits(static_cast<data_type &&>().FactoryBits), InstanceHasMoreThanOneDecl(static_cast<data_type &&>().InstanceHasMoreThanOneDecl), FactoryHasMoreThanOneDecl(static_cast<data_type &&>().FactoryHasMoreThanOneDecl), Instance(static_cast<data_type &&>().Instance), Factory(static_cast<data_type &&>().Factory) 
      //START JInit
      this.ID = $Prm0.ID;
      this.InstanceBits = $Prm0.InstanceBits;
      this.FactoryBits = $Prm0.FactoryBits;
      this.InstanceHasMoreThanOneDecl = $Prm0.InstanceHasMoreThanOneDecl;
      this.FactoryHasMoreThanOneDecl = $Prm0.FactoryHasMoreThanOneDecl;
      this.Instance = new SmallVector<ObjCMethodDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.Instance);
      this.Factory = new SmallVector<ObjCMethodDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.Factory);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::data_type::data_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 202,
     FQN="clang::serialization::reader::ASTSelectorLookupTrait::data_type::data_type", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeC1Ev")
    //</editor-fold>
    public /*inline*/ data_type() {
      // : Instance(), Factory() 
      //START JInit
      this.Instance = new SmallVector<ObjCMethodDecl /*P*/ >(2, (ObjCMethodDecl /*P*/ )null);
      this.Factory = new SmallVector<ObjCMethodDecl /*P*/ >(2, (ObjCMethodDecl /*P*/ )null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::data_type::~data_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 202,
     FQN="clang::serialization::reader::ASTSelectorLookupTrait::data_type::~data_type", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait9data_typeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Factory.$destroy();
      Instance.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "ID=" + ID // NOI18N
                + ", InstanceBits=" + InstanceBits // NOI18N
                + ", FactoryBits=" + FactoryBits // NOI18N
                + ", InstanceHasMoreThanOneDecl=" + InstanceHasMoreThanOneDecl // NOI18N
                + ", FactoryHasMoreThanOneDecl=" + FactoryHasMoreThanOneDecl // NOI18N
                + ", Instance=" + "[SmallVector$ObjCMethodDecl]" // NOI18N
                + ", Factory=" + "[SmallVector$ObjCMethodDecl]"; // NOI18N
    }
  };
  
  // JAVA: typedef Selector external_key_type
//  public final class external_key_type extends Selector{ };
  // JAVA: typedef external_key_type internal_key_type
//  public final class internal_key_type extends Selector{ };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::ASTSelectorLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 217,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::ASTSelectorLookupTrait", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTraitC1ERNS_9ASTReaderERNS0_10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTraitC1ERNS_9ASTReaderERNS0_10ModuleFileE")
  //</editor-fold>
  public ASTSelectorLookupTrait(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ F) {
    // : Reader(Reader), F(F) 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this./*&*/F=/*&*/F;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::EqualKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 220,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::EqualKey", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait8EqualKeyERKNS_8SelectorES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait8EqualKeyERKNS_8SelectorES5_")
  //</editor-fold>
  @Override public final boolean EqualKey(final /*const*/ Selector /*&*/ a, 
          final /*const*/ Selector /*&*/ b) {
    return a.$eq(/*NO_COPY*/b);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 667,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::ComputeHash", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait11ComputeHashENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait11ComputeHashENS_8SelectorE")
  //</editor-fold>
  @Override public final /*uint*/int ComputeHash(Selector Sel) {
    return SerializationStatics.ComputeHash(new Selector(Sel));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::GetInternalKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 227,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::GetInternalKey", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait14GetInternalKeyERKNS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait14GetInternalKeyERKNS_8SelectorE")
  //</editor-fold>
  @Override public final /*const*/ Selector /*&*/ GetInternalKey(final /*const*/ Selector /*&*/ x) {
    return x;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::ReadKeyDataLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 672,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::ReadKeyDataLength", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait17ReadKeyDataLengthERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait17ReadKeyDataLengthERPKh")
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::ReadKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 680,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::ReadKey", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait7ReadKeyEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait7ReadKeyEPKhj")
  //</editor-fold>
  @Override public final Selector ReadKey(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, /*uint*/int $Prm1) {
    //JAVA: using namespace llvm::support;
    final SelectorTable /*&*/ SelTable = Reader.getContext().Selectors;
    /*uint*/int N = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
                                            OffsetInBuf += NativeType.sizeof$uint16();
    final int read_first_offset = endian.read_uint32(endianness.little, llvm.support.unaligned, Buf, OffsetInBuf);
                                            OffsetInBuf += NativeType.sizeof$uint32();
    IdentifierInfo /*P*/ FirstII = Reader.getLocalIdentifier(F, read_first_offset);
    if (N == 0) {
      return SelTable.getNullarySelector(FirstII);
    } else if (N == 1) {
      return SelTable.getUnarySelector(FirstII);
    }
    
    SmallVector<IdentifierInfo /*P*/> Args/*J*/= new SmallVector<IdentifierInfo /*P*/>(16, (IdentifierInfo /*P*/)null);
    Args.push_back(FirstII);
    for (/*uint*/int I = 1; I != N; ++I)  {
      final int read_offset = endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf);
                OffsetInBuf += NativeType.sizeof$uint32();
      Args.push_back(Reader.getLocalIdentifier(F, read_offset));
    }
    
    return SelTable.getSelector(N, Args.data());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::ReadData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 701,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::ReadData", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTrait8ReadDataENS_8SelectorEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTrait8ReadDataENS_8SelectorEPKhj")
  //</editor-fold>
  @Override public final ASTSelectorLookupTrait.data_type ReadData(Selector $Prm0, /*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, 
          /*uint*/int DataLen) {
    data_type Result = null;
    try {
      //JAVA: using namespace llvm::support;
      
      Result/*J*/= new data_type();
      
      Result.ID = Reader.getGlobalSelectorID(F, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                                    OffsetInBuf += NativeType.sizeof$uint32();
      /*uint*/int FullInstanceBits = $ushort2uint(endian.read_uint16(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                                    OffsetInBuf += NativeType.sizeof$uint16();
      /*uint*/int FullFactoryBits = $ushort2uint(endian.read_uint16(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                                    OffsetInBuf += NativeType.sizeof$uint16();
      Result.InstanceBits = FullInstanceBits & 0x3;
      Result.InstanceHasMoreThanOneDecl = (((FullInstanceBits >>> 2) & 0x1) != 0);
      Result.FactoryBits = FullFactoryBits & 0x3;
      Result.FactoryHasMoreThanOneDecl = (((FullFactoryBits >>> 2) & 0x1) != 0);
      /*uint*/int NumInstanceMethods = FullInstanceBits >>> 3;
      /*uint*/int NumFactoryMethods = FullFactoryBits >>> 3;
      
      // Load instance methods
      for (/*uint*/int I = 0; I != NumInstanceMethods; ++I) {
        {
          ObjCMethodDecl /*P*/ Method = Reader.<ObjCMethodDecl>GetLocalDeclAs(ObjCMethodDecl.class, F, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                                    OffsetInBuf += NativeType.sizeof$uint32();
          if ((Method != null)) {
            Result.Instance.push_back(Method);
          }
        }
      }
      
      // Load factory methods
      for (/*uint*/int I = 0; I != NumFactoryMethods; ++I) {
        {
          ObjCMethodDecl /*P*/ Method = Reader.<ObjCMethodDecl>GetLocalDeclAs(ObjCMethodDecl.class, F, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                                    OffsetInBuf += NativeType.sizeof$uint32();
          if ((Method != null)) {
            Result.Factory.push_back(Method);
          }
        }
      }
      
      return new ASTSelectorLookupTrait.data_type(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTSelectorLookupTrait::ASTSelectorLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 197,
   FQN="clang::serialization::reader::ASTSelectorLookupTrait::ASTSelectorLookupTrait", NM="_ZN5clang13serialization6reader22ASTSelectorLookupTraitC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader22ASTSelectorLookupTraitC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ASTSelectorLookupTrait(final /*const*/ ASTSelectorLookupTrait /*&*/ $Prm0) {
    // : Reader(.Reader), F(.F) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/F=/*&*/$Prm0.F;
    //END JInit
  }

  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", F=" + F; // NOI18N
  }
}
