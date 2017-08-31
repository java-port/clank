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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import org.llvm.support.OnDiskChainedHashTableGenerator;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;
import org.llvm.support.raw_ostream;

// Trait used for the on-disk hash table used in the method pool.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2864,
 FQN="(anonymous namespace)::ASTMethodPoolTrait", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTraitE")
//</editor-fold>
public class ASTMethodPoolTrait implements OnDiskChainedHashTableGenerator.EmitInfoInterface<Selector, ASTMethodPoolTrait.data_type, Void/*unused*/> {
  private final ASTWriter /*&*/ Writer;
/*public:*/
  // JAVA: typedef Selector key_type
//  public final class key_type extends Selector{ };
  // JAVA: typedef key_type key_type_ref
//  public final class key_type_ref extends Selector{ };

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::data_type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2871,
   FQN="(anonymous namespace)::ASTMethodPoolTrait::data_type", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTrait9data_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTrait9data_typeE")
  //</editor-fold>
  public static class/*struct*/ data_type {
    public /*uint32_t*/int ID;
    public ObjCMethodList Instance;
    public ObjCMethodList Factory;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::data_type::data_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2871,
     FQN="(anonymous namespace)::ASTMethodPoolTrait::data_type::data_type", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTrait9data_typeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTrait9data_typeC1ERKS1_")
    //</editor-fold>
    public /*inline*/ data_type(final /*const*/ data_type /*&*/ $Prm0) {
      // : ID(.ID), Instance(.Instance), Factory(.Factory) 
      //START JInit
      this.ID = $Prm0.ID;
      this.Instance = new ObjCMethodList($Prm0.Instance);
      this.Factory = new ObjCMethodList($Prm0.Factory);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public data_type(int ID, ObjCMethodList Instance, ObjCMethodList Factory) {
      this.ID = ID;
      this.Instance = Instance;
      this.Factory = Factory;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "ID=" + ID // NOI18N
                + ", Instance=" + Instance // NOI18N
                + ", Factory=" + Factory; // NOI18N
    }
  };
  // JAVA: typedef const data_type &data_type_ref
//  public final class data_type_ref extends /*const*/ data_type /*&*/ { };
  
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::ASTMethodPoolTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2880,
   FQN="(anonymous namespace)::ASTMethodPoolTrait::ASTMethodPoolTrait", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTraitC1ERN5clang9ASTWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTraitC1ERN5clang9ASTWriterE")
  //</editor-fold>
  public /*explicit*/ ASTMethodPoolTrait(final ASTWriter /*&*/ Writer) {
    // : Writer(Writer) 
    //START JInit
    this./*&*/Writer=/*&*/Writer;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2882,
   FQN="(anonymous namespace)::ASTMethodPoolTrait::ComputeHash", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTrait11ComputeHashEN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTrait11ComputeHashEN5clang8SelectorE")
  //</editor-fold>
  @Override
  public /*uint*/int ComputeHash(Selector Sel) {
    return SerializationStatics.ComputeHash(new Selector(Sel));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2886,
   FQN="(anonymous namespace)::ASTMethodPoolTrait::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEN5clang8SelectorERKNS0_9data_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEN5clang8SelectorERKNS0_9data_typeE")
  //</editor-fold>
  @Override public final std.pairUIntUInt EmitKeyDataLength(final raw_ostream /*&*/ Out, Selector Sel, 
                   final /*const*/ data_type /*&*/ Methods) {
    throw new UnsupportedOperationException("EmitKeyDataLength$WrapPair must be used");
  }
  @Override public final /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(final raw_ostream /*&*/ Out, Selector Sel, 
                   final /*const*/ data_type /*&*/ Methods) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    /*uint*/int KeyLen = 2 + ((Sel.getNumArgs() != 0) ? Sel.getNumArgs() * 4 : 4);
    LE.write_uint16($uint2ushort(KeyLen));
    /*uint*/int DataLen = 4 + 2 + 2; // 2 bytes for each of the method counts
    for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.Instance); (Method != null);
         Method = Method.getNext())  {
      if ((Method.getMethod() != null)) {
        DataLen += 4;
      }
    }
    for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.Factory); (Method != null);
         Method = Method.getNext())  {
      if ((Method.getMethod() != null)) {
        DataLen += 4;
      }
    }
    LE.write_uint16($uint2ushort(DataLen));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::EmitKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2906,
   FQN="(anonymous namespace)::ASTMethodPoolTrait::EmitKey", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTrait7EmitKeyERN4llvm11raw_ostreamEN5clang8SelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTrait7EmitKeyERN4llvm11raw_ostreamEN5clang8SelectorEj")
  //</editor-fold>
  @Override public final void EmitKey(final raw_ostream /*&*/ Out, Selector Sel, /*uint*/int $Prm2) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    long/*uint64_t*/ Start = Out.tell();
    assert ((Start >>> 32) == $int2ullong(0)) : "Selector key offset too large";
    Writer.SetSelectorOffset(new Selector(Sel), $ulong2uint(Start));
    /*uint*/int N = Sel.getNumArgs();
    LE.write_uint16($uint2ushort(N));
    if (N == 0) {
      N = 1;
    }
    for (/*uint*/int I = 0; I != N; ++I)  {
      LE.write_uint32(Writer.getIdentifierRef(Sel.getIdentifierInfoForSlot(I)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMethodPoolTrait::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2921,
   FQN="(anonymous namespace)::ASTMethodPoolTrait::EmitData", NM="_ZN12_GLOBAL__N_118ASTMethodPoolTrait8EmitDataERN4llvm11raw_ostreamEN5clang8SelectorERKNS0_9data_typeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_118ASTMethodPoolTrait8EmitDataERN4llvm11raw_ostreamEN5clang8SelectorERKNS0_9data_typeEj")
  //</editor-fold>
  @Override public final void EmitData(final raw_ostream /*&*/ Out, Selector $Prm1, 
          final /*const*/ data_type /*&*/ Methods, /*uint*/int DataLen) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    long/*uint64_t*/ Start = Out.tell();
    ///*J:(void)*/Start;
    LE.write_uint32(Methods.ID);
    /*uint*/int NumInstanceMethods = 0;
    for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.Instance); (Method != null);
         Method = Method.getNext())  {
      if ((Method.getMethod() != null)) {
        ++NumInstanceMethods;
      }
    }
    
    /*uint*/int NumFactoryMethods = 0;
    for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.Factory); (Method != null);
         Method = Method.getNext())  {
      if ((Method.getMethod() != null)) {
        ++NumFactoryMethods;
      }
    }
    
    /*uint*/int InstanceBits = Methods.Instance.getBits();
    assert ($less_uint(InstanceBits, 4));
    /*uint*/int InstanceHasMoreThanOneDeclBit = (Methods.Instance.hasMoreThanOneDecl() ? 1 : 0);
    /*uint*/int FullInstanceBits = (NumInstanceMethods << 3)
       | (InstanceHasMoreThanOneDeclBit << 2)
       | InstanceBits;
    /*uint*/int FactoryBits = Methods.Factory.getBits();
    assert ($less_uint(FactoryBits, 4));
    /*uint*/int FactoryHasMoreThanOneDeclBit = (Methods.Factory.hasMoreThanOneDecl() ? 1 : 0);
    /*uint*/int FullFactoryBits = (NumFactoryMethods << 3)
       | (FactoryHasMoreThanOneDeclBit << 2)
       | FactoryBits;
    LE.write_uint16($uint2ushort(FullInstanceBits));
    LE.write_uint16($uint2ushort(FullFactoryBits));
    for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.Instance); (Method != null);
         Method = Method.getNext())  {
      if ((Method.getMethod() != null)) {
        LE.write_uint32(Writer.getDeclID(Method.getMethod()));
      }
    }
    for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.Factory); (Method != null);
         Method = Method.getNext())  {
      if ((Method.getMethod() != null)) {
        LE.write_uint32(Writer.getDeclID(Method.getMethod()));
      }
    }
    assert (Out.tell() - Start == $uint2ullong(DataLen)) : "Data length is wrong";
  }
  
  @Override public String toString() {
    return "" + "Writer=" + Writer; // NOI18N
  }
}
