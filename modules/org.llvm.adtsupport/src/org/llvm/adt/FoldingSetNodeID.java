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

package org.llvm.adt;

import static org.clank.support.Native.$Deref;
import java.util.Objects;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.sys.*;


//===--------------------------------------------------------------------===//
/// FoldingSetNodeID - This class is used to gather all the unique data bits of
/// a node.  When all the bits are gathered this class is used to produce a
/// hash value for the node.
///
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 296,
 FQN="llvm::FoldingSetNodeID", NM="_ZN4llvm16FoldingSetNodeIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeIDE")
//</editor-fold>
public class FoldingSetNodeID implements NativeFoldingSetTrait.NativeFoldingSetNodeID, Destructors.ClassWithDestructor, Native.NativeComparable<FoldingSetNodeID> {
  /// Bits - Vector of all the data bits that make the node unique.
  /// Use a SmallVector to avoid a heap allocation in the common case.
  private SmallVectorUInt Bits;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::FoldingSetNodeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 302,
   FQN="llvm::FoldingSetNodeID::FoldingSetNodeID", NM="_ZN4llvm16FoldingSetNodeIDC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeIDC1Ev")
  //</editor-fold>
  public FoldingSetNodeID() {
    /* : Bits()*/ 
    //START JInit
    this.Bits = new SmallVectorUInt(32, 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::FoldingSetNodeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 304,
   FQN="llvm::FoldingSetNodeID::FoldingSetNodeID", NM="_ZN4llvm16FoldingSetNodeIDC1ENS_19FoldingSetNodeIDRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeIDC1ENS_19FoldingSetNodeIDRefE")
  //</editor-fold>
  public FoldingSetNodeID(FoldingSetNodeIDRef Ref) {
    /* : Bits(Ref.getData(), Ref.getData() + Ref.getSize())*/ 
    //START JInit
    this.Bits = new SmallVectorUInt(32, Ref.getData(), Ref.getData().$add(Ref.getSize()), 0);
    //END JInit
  }

  
  /// Add* - Add various data types to Bit data.
  ///
  
  /// Add* - Add various data types to Bit data.
  ///
  
  //===----------------------------------------------------------------------===//
  // FoldingSetNodeID Implementation
  
  /// Add* - Add various data types to Bit data.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 52,
   FQN="llvm::FoldingSetNodeID::AddPointer", NM="_ZN4llvm16FoldingSetNodeID10AddPointerEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddPointerEPKv")
  //</editor-fold>
  public void AddPointer(/*const*/type$ptr<?>/*void P*/ Ptr) {
    // Note: this adds pointers to the hash using sizes and endianness that
    // depend on the host. It doesn't matter, however, because hashing on
    // pointer values is inherently unstable. Nothing should depend on the
    // ordering of nodes in the folding set.
// >>>>>
//    Bits.append(reinterpret_cast(uint$ptr/*uint P*/ .class, Ptr.$addr()), 
//        reinterpret_cast(uint$ptr/*uint P*/ .class, Ptr.$addr().$add(1)));
// <<<<<
      Bits.push_back(Objects.hash(System.identityHashCode(Ptr.$array()), Ptr.$index()));
// >>>>>
  }
  
  // JAVA: Clone of AddPointer when there is no array where objects are reside
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 52,
   FQN="llvm::FoldingSetNodeID::AddPointer", NM="_ZN4llvm16FoldingSetNodeID10AddPointerEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddPointerEPKv")
  //</editor-fold>
  @Override public void AddPointer(/*const*/Object/*void P*/ Ptr) {
    if (Ptr instanceof PointerUnionBase) {
      AddPointer((PointerUnionBase)Ptr);
    } else if (Ptr instanceof PointerIntPair) {
      AddPointer((PointerIntPair)Ptr);
    } else if (Ptr instanceof PointerInt2Pair) {
      AddPointer((PointerInt2Pair)Ptr);
    } else if (Ptr instanceof PointerEnum2Pair) {
      AddPointer((PointerEnum2Pair)Ptr);
    } else if (Ptr instanceof PointerBoolPair) {
      AddPointer((PointerBoolPair)Ptr);
    } else if (Ptr instanceof void$ptr) {
      throw new UnsupportedOperationException("AddPointer? Please, handle differently in client:" + NativeTrace.getIdentityStr(Ptr));
    } else if (Ptr instanceof Number) {
      throw new UnsupportedOperationException("AddPointer?" + NativeTrace.getIdentityStr(Ptr) + ". If this is void* to uintptr_p, please handle it manuall y in client i.e. by calling AddInteger_uint");
    } else {
      Bits.push_back(System.identityHashCode(Ptr));
    }
  }
  public void AddPointer(/*const*/PointerUnionBase/*void P*/ Ptr) {
    Ptr.ProfilePointerUnion(this);
  }
  public void AddPointer(/*const*/PointerIntPair/*void P*/ Ptr) {
    Ptr.ProfilePointerIntPair(this);
  }
  public void AddPointer(/*const*/PointerInt2Pair/*void P*/ Ptr) {
    Ptr.ProfilePointerIntPair(this);
  }
  public void AddPointer(/*const*/PointerEnum2Pair/*void P*/ Ptr) {
    Ptr.ProfilePointerIntPair(this);
  }
  public void AddPointer(/*const*/PointerBoolPair/*void P*/ Ptr) {
    Ptr.ProfilePointerIntPair(this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 60,
   FQN="llvm::FoldingSetNodeID::AddInteger", NM="_ZN4llvm16FoldingSetNodeID10AddIntegerEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddIntegerEi")
  //</editor-fold>
  @Override public void AddInteger_int(int I) {
    Bits.push_back(I);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 63,
   FQN="llvm::FoldingSetNodeID::AddInteger", NM="_ZN4llvm16FoldingSetNodeID10AddIntegerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddIntegerEj")
  //</editor-fold>
  @Override public void AddInteger_uint(/*uint*/int I) {
    Bits.push_back(I);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 66,
   FQN="llvm::FoldingSetNodeID::AddInteger", NM="_ZN4llvm16FoldingSetNodeID10AddIntegerEl",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddIntegerEl")
  //</editor-fold>
  @Override public void AddInteger_long(long I) {
    AddInteger_ulong((/*ulong*/long)I);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 69,
   FQN="llvm::FoldingSetNodeID::AddInteger", NM="_ZN4llvm16FoldingSetNodeID10AddIntegerEm",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddIntegerEm")
  //</editor-fold>
  @Override public void AddInteger_ulong(/*ulong*/long I) {
    if (sizeof(long.class) == sizeof(int.class)) {
      AddInteger_uint(((/*uint*/int)(I)));
    } else if (sizeof(long.class) == sizeof(/*llong*/long.class)) {
      AddInteger_ullong((/*ullong*/long)$ulong2ullong(I));
    } else {
      throw new llvm_unreachable("unexpected sizeof(long)");
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 78,
   FQN="llvm::FoldingSetNodeID::AddInteger", NM="_ZN4llvm16FoldingSetNodeID10AddIntegerEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddIntegerEx")
  //</editor-fold>
  @Override public void AddInteger_llong(/*llong*/long I) {
    AddInteger_ullong((/*ullong*/long)I);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddInteger">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 81,
   FQN="llvm::FoldingSetNodeID::AddInteger", NM="_ZN4llvm16FoldingSetNodeID10AddIntegerEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddIntegerEy")
  //</editor-fold>
  @Override public void AddInteger_ullong(/*ullong*/long I) {
    AddInteger_uint(((/*uint*/int)((I))));
    if ($uint2ullong((/*uint*/int)I) != I) {
      Bits.push_back(((/*uint*/int)((I >>> 32))));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddBoolean">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 316,
   FQN="llvm::FoldingSetNodeID::AddBoolean", NM="_ZN4llvm16FoldingSetNodeID10AddBooleanEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeID10AddBooleanEb")
  //</editor-fold>
  @Override public void AddBoolean(boolean B) {
    AddInteger_uint(B ? 1/*U*/ : 0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 87,
   FQN="llvm::FoldingSetNodeID::AddString", NM="_ZN4llvm16FoldingSetNodeID9AddStringENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID9AddStringENS_9StringRefE")
  //</editor-fold>
  public void AddString(StringRef String) {
    /*uint*/int Size = String.size();
    Bits.push_back(Size);
    if (!(Size != 0)) {
      return;
    }
    
    /*uint*/int Units = Size / 4;
    /*uint*/int Pos = 0;
    /*const*/uint$ptr/*uint P*/ Base = $tryClone(reinterpret_cast(/*const*/uint$ptr/*uint P*/ .class, String.data()));
    
    // If the string is aligned do a bulk transfer.
    if (false /*!(((Object)Base & 3) != 0)*/) {
      // JAVA: it is impossible to implement bulk transfer because char$ptr 
      // has different underlying implemntations. 
      Bits.append_T(Base, Base.$add(Units));
      Pos = (Units + 1) * 4;
    } else {
      // Otherwise do it the hard way.
      // To be compatible with above bulk transfer, we need to take endianness
      // into account.
      assert sys.IsBigEndianHost || sys.IsLittleEndianHost : $("Unexpected host endianness");
      if (sys.IsBigEndianHost) {
        for (Pos += 4; $lesseq_uint(Pos, Size); Pos += 4) {
          /*uint*/int V = ($uchar2int((/*uchar*/byte)String.$at(Pos - 4)) << 24)
             | ($uchar2int((/*uchar*/byte)String.$at(Pos - 3)) << 16)
             | ($uchar2int((/*uchar*/byte)String.$at(Pos - 2)) << 8)
             | $uchar2int((/*uchar*/byte)String.$at(Pos - 1));
          Bits.push_back(V);
        }
      } else { // Little-endian host
        for (Pos += 4; $lesseq_uint(Pos, Size); Pos += 4) {
          /*uint*/int V = ($uchar2int((/*uchar*/byte)String.$at(Pos - 1)) << 24)
             | ($uchar2int((/*uchar*/byte)String.$at(Pos - 2)) << 16)
             | ($uchar2int((/*uchar*/byte)String.$at(Pos - 3)) << 8)
             | $uchar2int((/*uchar*/byte)String.$at(Pos - 4));
          Bits.push_back(V);
        }
      }
    }
    
    // With the leftover bits.
    /*uint*/int V = 0;
    // Pos will have overshot size by 4 - #bytes left over.
    // No need to take endianness into account here - this is always executed.
    switch (Pos - Size) {
     case 1:
      V = (V << 8) | $uchar2uint((/*uchar*/byte)String.$at(Size - 3)); // Fall thru.
     case 2:
      V = (V << 8) | $uchar2uint((/*uchar*/byte)String.$at(Size - 2)); // Fall thru.
     case 3:
      V = (V << 8) | $uchar2uint((/*uchar*/byte)String.$at(Size - 1));
      break;
     default:
      return; // Nothing left.
    }
    
    Bits.push_back(V);
  }


  
  // AddNodeID - Adds the Bit data of another ID to *this.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::AddNodeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 140,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 139,
   FQN="llvm::FoldingSetNodeID::AddNodeID", NM="_ZN4llvm16FoldingSetNodeID9AddNodeIDERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetNodeID9AddNodeIDERKS0_")
  //</editor-fold>
  public void AddNodeID(/*const*/ FoldingSetNodeID /*&*/ ID) {
    Bits.append_T(ID.Bits.begin(), ID.Bits.end());
  }


  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::Add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 321,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 320,
   FQN="llvm::FoldingSetNodeID::Add", NM="Tpl__ZN4llvm16FoldingSetNodeID3AddERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=Tpl__ZN4llvm16FoldingSetNodeID3AddERKT_")
  //</editor-fold>
  public /*inline*/ </*typename*/ T> void Add(FoldingSetTrait<T> trait,/*const*/ T /*&*/ x) {
    trait.Profile(x, /*Deref*/this);
  }

  
  /// clear - Clear the accumulated profile, allowing this FoldingSetNodeID
  /// object to be used to compute a new profile.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 325,
   FQN="llvm::FoldingSetNodeID::clear", NM="_ZN4llvm16FoldingSetNodeID5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeID5clearEv")
  //</editor-fold>
  public /*inline*/ void clear() {
    Bits.clear();
  }

  
  /// ComputeHash - Compute a strong hash value for this FoldingSetNodeID, used
  /// to lookup the node in the FoldingSetImpl.
  
  /// ComputeHash - Compute a strong hash value for this FoldingSetNodeID, used
  /// to lookup the node in the FoldingSetImpl.
  
  /// ComputeHash - Compute a strong hash value for this FoldingSetNodeID, used to 
  /// lookup the node in the FoldingSetImpl.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 146,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 145,
   FQN="llvm::FoldingSetNodeID::ComputeHash", NM="_ZNK4llvm16FoldingSetNodeID11ComputeHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetNodeID11ComputeHashEv")
  //</editor-fold>
  public /*uint*/int ComputeHash() /*const*/ {
    return new FoldingSetNodeIDRef(Bits.data(), Bits.size()).ComputeHash();
  }


  
  /// operator== - Used to compare two nodes to each other.
  ///
  
  /// operator== - Used to compare two nodes to each other.
  ///
  
  /// operator== - Used to compare two nodes to each other.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 152,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 151,
   FQN="llvm::FoldingSetNodeID::operator==", NM="_ZNK4llvm16FoldingSetNodeIDeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetNodeIDeqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/ FoldingSetNodeID /*&*/ RHS) /*const*/ {
    return /*Deref*/this.$eq(new FoldingSetNodeIDRef(RHS.Bits.data(), RHS.Bits.size()));
  }


  
  /// operator== - Used to compare two nodes to each other.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 158,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 157,
   FQN="llvm::FoldingSetNodeID::operator==", NM="_ZNK4llvm16FoldingSetNodeIDeqENS_19FoldingSetNodeIDRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetNodeIDeqENS_19FoldingSetNodeIDRefE")
  //</editor-fold>
  public boolean $eq(FoldingSetNodeIDRef RHS) /*const*/ {
    return new FoldingSetNodeIDRef(Bits.data(), Bits.size()).$eq(/*NO_COPY*/RHS);
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 336,
   FQN="llvm::FoldingSetNodeID::operator!=", NM="_ZNK4llvm16FoldingSetNodeIDneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK4llvm16FoldingSetNodeIDneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/ FoldingSetNodeID /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 337,
   FQN="llvm::FoldingSetNodeID::operator!=", NM="_ZNK4llvm16FoldingSetNodeIDneENS_19FoldingSetNodeIDRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK4llvm16FoldingSetNodeIDneENS_19FoldingSetNodeIDRefE")
  //</editor-fold>
  public boolean $noteq(/*const*/ FoldingSetNodeIDRef RHS) /*const*/ {
    return !(/*Deref*/this.$eq(/*NO_COPY*/RHS));
  }

  
  /// Used to compare the "ordering" of two nodes as defined by the
  /// profiled bits and their ordering defined by memcmp().
  
  /// Used to compare the "ordering" of two nodes as defined by the
  /// profiled bits and their ordering defined by memcmp().
  
  /// Used to compare the "ordering" of two nodes as defined by the
  /// profiled bits and their ordering defined by memcmp().
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 164,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 163,
   FQN="llvm::FoldingSetNodeID::operator<", NM="_ZNK4llvm16FoldingSetNodeIDltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetNodeIDltERKS0_")
  //</editor-fold>
  public boolean $less(/*const*/ FoldingSetNodeID /*&*/ RHS) /*const*/ {
    return $Deref(this.$less(new FoldingSetNodeIDRef(RHS.Bits.data(), RHS.Bits.size())));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 168,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 167,
   FQN="llvm::FoldingSetNodeID::operator<", NM="_ZNK4llvm16FoldingSetNodeIDltENS_19FoldingSetNodeIDRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetNodeIDltENS_19FoldingSetNodeIDRefE")
  //</editor-fold>
  public boolean $less(FoldingSetNodeIDRef RHS) /*const*/ {
    return new FoldingSetNodeIDRef(Bits.data(), Bits.size()).$less(/*NO_COPY*/RHS);
  }


  
  /// Intern - Copy this node's data to a memory region allocated from the
  /// given allocator and return a FoldingSetNodeIDRef describing the
  /// interned data.
  
  /// Intern - Copy this node's data to a memory region allocated from the
  /// given allocator and return a FoldingSetNodeIDRef describing the
  /// interned data.
  
  /// Intern - Copy this node's data to a memory region allocated from the
  /// given allocator and return a FoldingSetNodeIDRef describing the
  /// interned data.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::Intern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 175,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 174,
   FQN="llvm::FoldingSetNodeID::Intern", NM="_ZNK4llvm16FoldingSetNodeID6InternERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetNodeID6InternERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public FoldingSetNodeIDRef Intern(BumpPtrAllocatorImpl /*&*/ Allocator) /*const*/ {
    uint$ptr/*uint P*/ New = reinterpret_cast(uint$ptr.class, $tryClone(Allocator.Allocate(Bits.size() * sizeof(/*uint*/int.class))));
    std.uninitialized_copy(Bits.begin(), Bits.end(), New);
    return new FoldingSetNodeIDRef(New, Bits.size());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::FoldingSetNodeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 296,
   FQN="llvm::FoldingSetNodeID::FoldingSetNodeID", NM="_ZN4llvm16FoldingSetNodeIDC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeIDC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetNodeID(/*const*/ FoldingSetNodeID /*&*/ $Prm0) {
    /* : Bits(.Bits)*/ 
    //START JInit
    this.Bits = new SmallVectorUInt($Prm0.Bits);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::~FoldingSetNodeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 296,
   FQN="llvm::FoldingSetNodeID::~FoldingSetNodeID", NM="_ZN4llvm16FoldingSetNodeIDD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeIDD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Bits.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 296,
   FQN="llvm::FoldingSetNodeID::operator=", NM="_ZN4llvm16FoldingSetNodeIDaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN4llvm16FoldingSetNodeIDaSERKS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetNodeID /*&*/ $assign(/*const*/ FoldingSetNodeID /*&*/ $Prm0) {
    this.Bits.$assign($Prm0.Bits);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeID::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 296,
   FQN="llvm::FoldingSetNodeID::operator=", NM="_ZN4llvm16FoldingSetNodeIDaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN4llvm16FoldingSetNodeIDaSEOS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetNodeID /*&*/ $assignMove(FoldingSetNodeID /*&&*/$Prm0) {
    this.Bits.$assignMove($Prm0.Bits);
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "Bits=" + Bits; // NOI18N
  }

  public void Add(FoldingSetTrait.Profilable Obj) {
    if (Obj != null) {
      Obj.Profile(this);
    }
  }

  public void Add(NativeFoldingSetTrait.NativeProfilable Obj) {
    if (Obj != null) {
      Obj.Profile(this);
    }
  }

  public void Add(Object Pos) {
    throw new UnsupportedOperationException("Must be FoldingSetTrait.Profilable OR NativeFoldingSetTrait.NativeProfilable OR use one of Add* alternatives " + NativeTrace.getIdentityStr(Pos));
  }
}
