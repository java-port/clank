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

import static org.clank.support.Native.$AddrOf;
import org.llvm.support.sys.sys;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.HashingGlobals.hashing.detail.hash_combine_recursive_helper;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;

//<editor-fold defaultstate="collapsed" desc="static type llvm">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -file-filter=${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h -namespace=llvm")
//</editor-fold>
public final class HashingGlobals {
  private HashingGlobals() {}

/// \brief An opaque object representing a hash code.
///
/// This object represents the result of hashing some entity. It is intended to
/// be used to implement hashtables or other hashing-based data structures.
/// While it wraps and exposes a numeric value, this value should not be
/// trusted to be stable or predictable across processes or executions.
///
/// In order to obtain the hash_code for an object 'x':
/// \code
///   using llvm::hash_value;
///   llvm::hash_code code = hash_value(x);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="llvm::hash_code">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 73,
 FQN="llvm::hash_code", NM="_ZN4llvm9hash_codeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm9hash_codeE")
//</editor-fold>
public static class hash_code implements Native.NativePOD<hash_code> {
  // JAVA: we change type here manually to long, because size_t mapping to int 
  // is not enough according to current usage of this class
  private long/*uint64_t*/ value;
/*public:*/
  /// \brief Default construct a hash_code.
  /// Note that this leaves the value uninitialized.
  //<editor-fold defaultstate="collapsed" desc="llvm::hash_code::hash_code">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 79,
   FQN="llvm::hash_code::hash_code", NM="_ZN4llvm9hash_codeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm9hash_codeC1Ev")
  //</editor-fold>
  public hash_code() {
  }

  
  /// \brief Form a hash code directly from a numerical value.
  //<editor-fold defaultstate="collapsed" desc="llvm::hash_code::hash_code">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 82,
   FQN="llvm::hash_code::hash_code", NM="_ZN4llvm9hash_codeC1Em",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm9hash_codeC1Em")
  //</editor-fold>
  public hash_code(long/*uint64_t*/ value) {
    /* : value(value)*/ 
    //START JInit
    this.value = value;
    //END JInit
  }

  
  /// \brief Convert the hash code to its numerical value for use.
  /*explicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::hash_code::operator unsigned long">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 85,
   FQN="llvm::hash_code::operator unsigned long", NM="_ZNK4llvm9hash_codecvmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZNK4llvm9hash_codecvmEv")
  //</editor-fold>
  public long/*uint64_t*/ $ulong() /*const*/ {
    return value;
  }

  public /*uint*/int $uint() /*const*/ {
    return (int)value;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 87,
   FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_9hash_codeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvmeqERKNS_9hash_codeES2_")
  //</editor-fold>
  public static boolean $eq_hash_code(/*const*/ hash_code /*&*/ lhs, /*const*/ hash_code /*&*/ rhs) {
    return lhs.value == rhs.value;
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 90,
   FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_9hash_codeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvmneERKNS_9hash_codeES2_")
  //</editor-fold>
  public static boolean $noteq_hash_code(/*const*/ hash_code /*&*/ lhs, /*const*/ hash_code /*&*/ rhs) {
    return lhs.value != rhs.value;
  }

  @Override
  public hash_code $assign(hash_code other) {
    this.value = other.value;
    return this;
  }

  public hash_code $assignMove(hash_code other) {
    this.value = other.value;
    return this;
  }
  
  @Override
  public hash_code clone() {
    return new hash_code(this.value);
  }
  
  @Override
  public boolean $noteq(hash_code other) {
    return $noteq_hash_code(this, other);
  }

  @Override
  public boolean $eq(hash_code other) {
    return $eq_hash_code(this, other);
  }
  
  /// \brief Allow a hash_code to be directly run through hash_value.
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 95,
   FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_9hash_codeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm10hash_valueERKNS_9hash_codeE")
  //</editor-fold>
  public static long/*uint64_t*/ hash_value(/*const*/ hash_code /*&*/ code) {
    return code.value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::hash_code::hash_code">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 73,
   FQN="llvm::hash_code::hash_code", NM="_ZN4llvm9hash_codeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm9hash_codeC1EOS0_")
  //</editor-fold>
  public /*inline*/ hash_code(hash_code /*&&*/$Prm0) {
    /* : value(static_cast<hash_code &&>().value)*/ 
    //START JInit
    this.value = $Prm0.value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::hash_code::hash_code">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 73,
   FQN="llvm::hash_code::hash_code", NM="_ZN4llvm9hash_codeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm9hash_codeC1EOS0_")
  //</editor-fold>
  public /*inline*/ hash_code(JD$Move _dparam, hash_code /*&&*/$Prm0) {
    /* : value(static_cast<hash_code &&>().value)*/ 
    //START JInit
    this.value = $Prm0.value;
    //END JInit
  }

  
  public String toString() {
    return "" + "value=" + value; // NOI18N
  }
}
/*template <typename T> TEMPLATE*/

/// \brief Compute a hash_code for any integer value.
///
/// Note that this function is intended to compute the same hash_code for
/// a particular value without regard to the pre-promotion type. This is in
/// contrast to hash_combine which may produce different hash_codes for
/// differing argument types even if they would implicit promote to a common
/// type without changing the value.
// namespace hashing

// Declared and documented above, but defined here so that any of the hashing
// infrastructure is available.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 737,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_value")
//</editor-fold>
public static </*typename*/ T>  hash_code hash_value(T value) {
  assert false : "declare and use hash_value(" + value.getClass().getSimpleName() + ") specialization";
  return /*::*/hashing.detail.hash_integer_value(reinterpret_cast_long(value));
}
public static hash_code hash_value(byte value) {
  return /*::*/hashing.detail.hash_integer_value($uchar2ulong(value));
}
public static hash_code hash_value(short value) {
  return /*::*/hashing.detail.hash_integer_value($short2ulong(value));
}
public static hash_code hash_value(int value) {
  return /*::*/hashing.detail.hash_integer_value($uint2ulong(value));
}
public static hash_code hash_value(long value) {
  return /*::*/hashing.detail.hash_integer_value(value);
}
public static hash_code hash_value(boolean value) {
  return /*::*/hashing.detail.hash_integer_value(value ? 0 : 1);
}
public static hash_code hash_value(hash_code value) {
  return /*::*/value;
}

/*template <typename T> TEMPLATE*/

/// \brief Compute a hash_code for a pointer's address.
///
/// N.B.: This hashes the *address*. Not the value and not the type.

// Declared and documented above, but defined here so that any of the hashing
// infrastructure is available.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 640,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 743,
 FQN = "llvm::hash_value", NM = "Tpl__ZN4llvm10hash_valueEPKT_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=Tpl__ZN4llvm10hash_valueEPKT_")
//</editor-fold>
public static </*typename*/ T> hash_code hash_value(/*const*/ type$ptr<T> /*P*/ ptr) {
  assert false : "declare and use method without type$ptr : hash_value(" + ptr.$star().getClass().getSimpleName() + ") specialization";
  return /*::*/hashing.detail.hash_integer_value(reinterpret_cast_long/*uintptr_t*/(ptr));
}
public static <T /*P*/> hash_code hash_value_ptr(/*const*/ T /*&*/ ptr) {
  return /*::*/hashing.detail.get_hashable_ptr_data(/*uintptr_t*/ptr);
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 752,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_value")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> hash_code hash_value(/*const*/ std.pair<T, U> /*&*/ arg) {
  assert false : "declare and use method without pair : hash_combine(" + 
          arg.first.getClass().getSimpleName() + 
          ", " + arg.second.getClass().getSimpleName() + 
          ") specialization";
  return hash_combine(arg.first, arg.second);
}

/*template <typename T> TEMPLATE*/

/// \brief Compute a hash_code for a standard string.

// Declared and documented above, but defined here so that any of the hashing
// infrastructure is available.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 759,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_value")
//</editor-fold>
public static hash_code hash_value(/*const*/ std.string /*&*/ arg) {
  return hash_combine_range(arg.begin(), arg.end());
}

/// \brief Compute a hash_code for a StringRef.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 522,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 483,
 FQN = "llvm::hash_value", NM = "_ZN4llvm10hash_valueENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm10hash_valueENS_9StringRefE")
//</editor-fold>
public static hash_code hash_value(StringRef S) {
  return hash_combine_range(S.begin(), S.end());
}

/// \brief Override the execution seed with a fixed value.
///
/// This hashing library uses a per-execution seed designed to change on each
/// run with high probability in order to ensure that the hash codes are not
/// attackable and to ensure that output which is intended to be stable does
/// not rely on the particulars of the hash codes produced.
///
/// That said, there are use cases where it is important to be able to
/// reproduce *exactly* a specific behavior. To that end, we provide a function
/// which will forcibly set the seed to a fixed value. This must be done at the
/// start of the program, before any hashes are computed. Also, it cannot be
/// undone. This makes it thread-hostile and very hard to use outside of
/// immediately on start of a simple program designed for reproducible
/// behavior.

// Implement the function for forced setting of the fixed seed.
// FIXME: Use atomic operations here so that there is no data race.
//<editor-fold defaultstate="collapsed" desc="llvm::set_fixed_execution_hash_seed">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Hashing.cpp", line = 27,
 FQN = "llvm::set_fixed_execution_hash_seed", NM = "_ZN4llvm29set_fixed_execution_hash_seedEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm29set_fixed_execution_hash_seedEj")
//</editor-fold>
public static void set_fixed_execution_hash_seed(/*size_t*/int fixed_value) {
  hashing.detail.fixed_seed_override = fixed_value;
}

//JAVA: namespace hashing {
public static final class hashing {
  //JAVA: namespace detail {
  public static final class detail {
    private static long fixed_seed_override = 0;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::fetch64">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 146,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 151,
     FQN = "llvm::hashing::detail::fetch64", NM = "_ZN4llvm7hashing6detail7fetch64EPKc",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail7fetch64EPKc")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ fetch64(/*const*/char$ptr/*char P*/ p) {
//      long$ptr/*uint64_t*/ result = create_long$ptr();
//      memcpy((long$ptr)/*AddrOf*/result, p, NativeType.BYTES_IN_LONG);
      long Value = ByteUtils.bytesToLong(p, 0, NativeType.BYTES_IN_LONG);
      if (sys.IsBigEndianHost) {
        Value = sys.SwapByteOrder_64(Value);
      }
      return Value;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::fetch32">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 154,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 159,
     FQN = "llvm::hashing::detail::fetch32", NM = "_ZN4llvm7hashing6detail7fetch32EPKc",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail7fetch32EPKc")
    //</editor-fold>
    public static /*inline*/ int/*uint32_t*/ fetch32(/*const*/char$ptr/*char P*/ p) {
//      uint$ptr/*uint32_t*/ result = create_uint$ptr();
//      memcpy(/*AddrOf*/result, p, NativeType.BYTES_IN_INT);
      /*uint*/int Value = ByteUtils.bytesToUInt(p, 0, NativeType.BYTES_IN_INT);
      if (sys.IsBigEndianHost) {
        Value = sys.SwapByteOrder_32(Value);
      }
      return Value;
    }

    
    /// Some primes between 2^63 and 2^64 for various uses.
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::k0">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 163,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 168,
     FQN = "llvm::hashing::detail::k0", NM = "_ZN4llvm7hashing6detailL2k0E",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detailL2k0E")
    //</editor-fold>
    public static /*const*/long/*uint64_t*/ k0 = 0xc3a5c85c97cb3127L/*ULL*/;
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::k1">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 164,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 169,
     FQN = "llvm::hashing::detail::k1", NM = "_ZN4llvm7hashing6detailL2k1E",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detailL2k1E")
    //</editor-fold>
    public static /*const*/long/*uint64_t*/ k1 = 0xb492b66fbe98f273L/*ULL*/;
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::k2">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 165,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 170,
     FQN = "llvm::hashing::detail::k2", NM = "_ZN4llvm7hashing6detailL2k2E",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detailL2k2E")
    //</editor-fold>
    public static /*const*/long/*uint64_t*/ k2 = 0x9ae16a3b2f90404fL/*ULL*/;
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::k3">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 166,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 171,
     FQN = "llvm::hashing::detail::k3", NM = "_ZN4llvm7hashing6detailL2k3E",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detailL2k3E")
    //</editor-fold>
    public static /*const*/long/*uint64_t*/ k3 = 0xc949d7c7509e6557L/*ULL*/;
    
    /// \brief Bitwise right rotate.
    /// Normally this will compile to a single instruction, especially if the
    /// shift is a manifest constant.
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::rotate">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 171,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 176,
     FQN = "llvm::hashing::detail::rotate", NM = "_ZN4llvm7hashing6detail6rotateEyj",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail6rotateEyj")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ rotate(long/*uint64_t*/ val, /*size_t*/int shift) {
      // Avoid shifting by 64: doing so yields an undefined result.
      return shift == 0 ? val : ((val >>> shift) | (val << (64 - shift)));
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::shift_mix">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 176,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 181,
     FQN = "llvm::hashing::detail::shift_mix", NM = "_ZN4llvm7hashing6detail9shift_mixEy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail9shift_mixEy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ shift_mix(long/*uint64_t*/ val) {
      return val ^ (val >>> 47);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_16_bytes">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 180,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 185,
     FQN = "llvm::hashing::detail::hash_16_bytes", NM = "_ZN4llvm7hashing6detail13hash_16_bytesEyy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail13hash_16_bytesEyy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_16_bytes(long/*uint64_t*/ low, long/*uint64_t*/ high) {
      // Murmur-inspired hashing.
      /*const*/long/*uint64_t*/ kMul = 0x9ddfea08eb382d69L/*ULL*/;
      long/*uint64_t*/ a = (low ^ high) * kMul;
      a ^= (a >>> 47);
      long/*uint64_t*/ b = (high ^ a) * kMul;
      b ^= (b >>> 47);
      b *= kMul;
      return b;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_1to3_bytes">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 191,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 196,
     FQN = "llvm::hashing::detail::hash_1to3_bytes", NM = "_ZN4llvm7hashing6detail15hash_1to3_bytesEPKcjy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail15hash_1to3_bytesEPKcjy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_1to3_bytes(/*const*/char$ptr/*char P*/ s, /*size_t*/int len, long/*uint64_t*/ seed) {
      byte/*uint8_t*/ a = s.$at(0);
      byte/*uint8_t*/ b = s.$at(len >>> 1);
      byte/*uint8_t*/ c = s.$at(len - 1);
      int/*uint32_t*/ y = (/*static_cast*/int/*uint32_t*/)(a & 0xff) + ((/*static_cast*/int/*uint32_t*/)(b & 0xff) << 8);
      int/*uint32_t*/ z = len + ((/*static_cast*/int/*uint32_t*/)(c & 0xff) << 2);
      return shift_mix(y * k2 ^ z * k3 ^ seed) * k2;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_4to8_bytes">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 200,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 205,
     FQN = "llvm::hashing::detail::hash_4to8_bytes", NM = "_ZN4llvm7hashing6detail15hash_4to8_bytesEPKcjy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail15hash_4to8_bytesEPKcjy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_4to8_bytes(/*const*/char$ptr/*char P*/ s, /*size_t*/int len, long/*uint64_t*/ seed) {
      long/*uint64_t*/ a = fetch32(s);
      return hash_16_bytes(len + (a << 3), seed ^ fetch32(s.$add(len).$sub(4)));
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_9to16_bytes">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 205,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 210,
     FQN = "llvm::hashing::detail::hash_9to16_bytes", NM = "_ZN4llvm7hashing6detail16hash_9to16_bytesEPKcjy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail16hash_9to16_bytesEPKcjy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_9to16_bytes(/*const*/char$ptr/*char P*/ s, /*size_t*/int len, long/*uint64_t*/ seed) {
      long/*uint64_t*/ a = fetch64(s);
      long/*uint64_t*/ b = fetch64(s.$add(len).$sub(8));
      return hash_16_bytes(seed ^ a, rotate(b + len, len)) ^ b;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_17to32_bytes">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 211,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 216,
     FQN = "llvm::hashing::detail::hash_17to32_bytes", NM = "_ZN4llvm7hashing6detail17hash_17to32_bytesEPKcjy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail17hash_17to32_bytesEPKcjy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_17to32_bytes(/*const*/char$ptr/*char P*/ s, /*size_t*/int len, long/*uint64_t*/ seed) {
      long/*uint64_t*/ a = fetch64(s) * k1;
      long/*uint64_t*/ b = fetch64(s.$add(8));
      long/*uint64_t*/ c = fetch64(s.$add(len).$sub(8)) * k2;
      long/*uint64_t*/ d = fetch64(s.$add(len).$sub(16)) * k0;
      return hash_16_bytes(rotate(a - b, 43) + rotate(c ^ seed, 30) + d, 
          a + rotate(b ^ k3, 20) - c + len + seed);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_33to64_bytes">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 220,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 225,
     FQN = "llvm::hashing::detail::hash_33to64_bytes", NM = "_ZN4llvm7hashing6detail17hash_33to64_bytesEPKcjy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail17hash_33to64_bytesEPKcjy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_33to64_bytes(/*const*/char$ptr/*char P*/ s, /*size_t*/int len, long/*uint64_t*/ seed) {
      long/*uint64_t*/ z = fetch64(s.$add(24));
      long/*uint64_t*/ a = fetch64(s) + (len + fetch64(s.$add(len).$sub(16))) * k0;
      long/*uint64_t*/ b = rotate(a + z, 52);
      long/*uint64_t*/ c = rotate(a, 37);
      a += fetch64(s.$add(8));
      c += rotate(a, 7);
      a += fetch64(s.$add(16));
      long/*uint64_t*/ vf = a + z;
      long/*uint64_t*/ vs = b + rotate(a, 31) + c;
      a = fetch64(s.$add(16)) + fetch64(s.$add(len).$sub(32));
      z = fetch64(s.$add(len).$sub(8));
      b = rotate(a + z, 52);
      c = rotate(a, 37);
      a += fetch64(s.$add(len).$sub(24));
      c += rotate(a, 7);
      a += fetch64(s.$add(len).$sub(16));
      long/*uint64_t*/ wf = a + z;
      long/*uint64_t*/ ws = b + rotate(a, 31) + c;
      long/*uint64_t*/ r = shift_mix((vf + ws) * k2 + (wf + vs) * k0);
      return shift_mix((seed ^ (r * k0)) + vs) * k2;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_short">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 243,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 248,
     FQN = "llvm::hashing::detail::hash_short", NM = "_ZN4llvm7hashing6detail10hash_shortEPKcjy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_shortEPKcjy")
    //</editor-fold>
    public static /*inline*/ long/*uint64_t*/ hash_short(/*const*/char$ptr/*char P*/ s, /*size_t*/int length, long/*uint64_t*/ seed) {
      if (length >= 4 && length <= 8) {
        return hash_4to8_bytes(s, length, seed);
      }
      if (length > 8 && length <= 16) {
        return hash_9to16_bytes(s, length, seed);
      }
      if (length > 16 && length <= 32) {
        return hash_17to32_bytes(s, length, seed);
      }
      if (length > 32) {
        return hash_33to64_bytes(s, length, seed);
      }
      if (length != 0) {
        return hash_1to3_bytes(s, length, seed);
      }
      
      return k2 ^ seed;
    }

    
    /// \brief The intermediate state used during hashing.
    /// Currently, the algorithm for computing hash codes is based on CityHash and
    /// keeps 56 bytes of arbitrary state.
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 261,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 266,
     FQN = "llvm::hashing::detail::hash_state", NM = "_ZN4llvm7hashing6detail10hash_stateE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_stateE")
    //</editor-fold>
    public static class/*struct*/ hash_state {
      public long/*uint64_t*/ h0;
      public long/*uint64_t*/ h1;
      public long/*uint64_t*/ h2;
      public long/*uint64_t*/ h3;
      public long/*uint64_t*/ h4;
      public long/*uint64_t*/ h5;
      public long/*uint64_t*/ h6;
      public long/*uint64_t*/ seed;
      
      /// \brief Create a new hash_state structure and initialize it based on the
      /// seed and the first 64-byte chunk.
      /// This effectively performs the initial mix.
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state::create">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 267,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 272,
       FQN = "llvm::hashing::detail::hash_state::create", NM = "_ZN4llvm7hashing6detail10hash_state6createEPKcy",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_state6createEPKcy")
      //</editor-fold>
      public static hash_state create(/*const*/char$ptr/*char P*/ s, long/*uint64_t*/ seed) {
        hash_state state = new hash_state(
          0, seed, hash_16_bytes(seed, k1), rotate(seed ^ k1, 49), 
          seed * k1, shift_mix(seed), 0, seed);
        state.h6 = hash_16_bytes(state.h4, state.h5);
        state.mix(s);
        return state;
      }

      
      /// \brief Mix 32-bytes from the input sequence into the 16-bytes of 'a'
      /// and 'b', including whatever is already in 'a' and 'b'.
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state::mix_32_bytes">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 278,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 283,
       FQN = "llvm::hashing::detail::hash_state::mix_32_bytes", NM = "_ZN4llvm7hashing6detail10hash_state12mix_32_bytesEPKcRyS5_",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_state12mix_32_bytesEPKcRyS5_")
      //</editor-fold>
      public static void mix_32_bytes(/*const*/char$ptr/*char P*/ s, long/*uint64_t*//*&*/ a, long/*uint64_t*//*&*/ b) {
        a += fetch64(s);
        long/*uint64_t*/ c = fetch64(s.$add(24));
        b = rotate(b + a + c, 21);
        long/*uint64_t*/ d = a;
        a += fetch64(s.$add(8)) + fetch64(s.$add(16));
        b += rotate(a, 44) + d;
        a += c;
      }

      
      /// \brief Mix in a 64-byte buffer of data.
      /// We mix all 64 bytes even when the chunk length is smaller, but we
      /// record the actual length.
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state::mix">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 291,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 296,
       FQN = "llvm::hashing::detail::hash_state::mix", NM = "_ZN4llvm7hashing6detail10hash_state3mixEPKc",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_state3mixEPKc")
      //</editor-fold>
      public void mix(/*const*/char$ptr/*char P*/ s) {
        h0 = rotate(h0 + h1 + h3 + fetch64(s.$add(8)), 37) * k1;
        h1 = rotate(h1 + h4 + fetch64(s.$add(48)), 42) * k1;
        h0 ^= h6;
        h1 += h3 + fetch64(s.$add(40));
        h2 = rotate(h2 + h5, 33) * k1;
        h3 = h4 * k1;
        h4 = h0 + h5;
        mix_32_bytes(s, h3, h4);
        h5 = h2 + h6;
        h6 = h1 + fetch64(s.$add(16));
        mix_32_bytes(s.$add(32), h5, h6);
//        std.swap(h2, h0);
        long/*uint64_t*/ h0Temp = h0;
        h0 = h2;
        h2 = h0Temp;
      }

      
      /// \brief Compute the final 64-bit hash code value based on the current
      /// state and the length of bytes hashed.
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state::finalize">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 308,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 313,
       FQN = "llvm::hashing::detail::hash_state::finalize", NM = "_ZN4llvm7hashing6detail10hash_state8finalizeEj",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_state8finalizeEj")
      //</editor-fold>
      public long/*uint64_t*/ finalize(/*size_t*/int length) {
        return hash_16_bytes(hash_16_bytes(h3, h5) + shift_mix(h1) * k1 + h2, 
            hash_16_bytes(h4, h6) + shift_mix(length) * k1 + h0);
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state::hash_state">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 261,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 266,
       FQN = "llvm::hashing::detail::hash_state::hash_state", NM = "_ZN4llvm7hashing6detail10hash_stateC1Ev",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_stateC1Ev")
      //</editor-fold>
      public /*inline*/ hash_state() {
      }

      public hash_state(long/*uint64_t*/ h0, long/*uint64_t*/ h1, long/*uint64_t*/ h2, 
              long/*uint64_t*/ h3, long/*uint64_t*/ h4, 
              long/*uint64_t*/ h5, long/*uint64_t*/ h6, 
              long/*uint64_t*/ seed) {
        this.h0 = h0;
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.h4 = h4;
        this.h5 = h5;
        this.h6 = h6;
        this.seed = seed;
      }
      
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_state::hash_state">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 261,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 266,
       FQN = "llvm::hashing::detail::hash_state::hash_state", NM = "_ZN4llvm7hashing6detail10hash_stateC1ERKS2_",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail10hash_stateC1ERKS2_")
      //</editor-fold>
      public /*inline*/ hash_state(/*const*/ hash_state /*&*/ $Prm0)/* throw()*/ {
        /* : h0(.h0), h1(.h1), h2(.h2), h3(.h3), h4(.h4), h5(.h5), h6(.h6), seed(.seed)*/ 
        //START JInit
        this.h0 = $Prm0.h0;
        this.h1 = $Prm0.h1;
        this.h2 = $Prm0.h2;
        this.h3 = $Prm0.h3;
        this.h4 = $Prm0.h4;
        this.h5 = $Prm0.h5;
        this.h6 = $Prm0.h6;
        this.seed = $Prm0.seed;
        //END JInit
      }

      public /*inline*/ hash_state $assign(/*const*/ hash_state /*&*/ $Prm0) {
        this.h0 = $Prm0.h0;
        this.h1 = $Prm0.h1;
        this.h2 = $Prm0.h2;
        this.h3 = $Prm0.h3;
        this.h4 = $Prm0.h4;
        this.h5 = $Prm0.h5;
        this.h6 = $Prm0.h6;
        this.seed = $Prm0.seed;
        return this;
      }      
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::get_execution_seed">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 322,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 327,
     FQN = "llvm::hashing::detail::get_execution_seed", NM = "_ZN4llvm7hashing6detail18get_execution_seedEv",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail18get_execution_seedEv")
    //</editor-fold>
    public static /*inline*/ /*uint64_t*/long get_execution_seed() {
      // FIXME: This needs to be a per-execution seed. This is just a placeholder
      // implementation. Switching to a per-execution seed is likely to flush out
      // instability bugs and so will happen as its own commit.
      //
      // However, if there is a fixed seed override set the first time this is
      // called, return that instead of the per-execution seed.
      return seed;
    }

    /*const*/static final long/*uint64_t*/ seed_prime = 0xff51afd7ed558ccdL/*ULL*/;
    static final /*uint64_t*/long seed = (fixed_seed_override != 0L) ? fixed_seed_override : seed_prime;
    
    /// \brief Trait to indicate whether a type's bits can be hashed directly.
    ///
    /// A type trait which is true if we want to combine values for hashing by
    /// reading the underlying data. It is false if values of this type must
    /// first be passed to hash_value, and the resulting hash_codes combined.
    //
    // FIXME: We want to replace is_integral_or_enum and is_pointer here with
    // a predicate which asserts that comparing the underlying storage of two
    // values of the type for equality is equivalent to comparing the two values
    // for equality. For all the platforms we care about, this holds for integers
    // and pointers, but there are platforms where it doesn't and we would like to
    // support user-defined types which happen to satisfy this property.
    /*template <typename T> TEMPLATE*/
//    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::is_hashable_data">
//    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 354,
//     cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::is_hashable_data")
//    //</editor-fold>
//    public static class/*struct*/ is_hashable_data</*typename*/ T>  extends /**/ integral_constant<boolean, ((is_integral_or_enum<T>.value
//   || is_pointer<T>.value)
//   && 64 % sizeof(T) == 0)> {
//    };
    
    // Special case std::pair to detect when both types are viable and when there
    // is no alignment-derived padding in the pair. This is a bit of a lie because
    // std::pair isn't truly POD, but it's close enough in all reasonable
    // implementations for our use case of hashing the underlying data.
//    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::is_hashable_data">
//    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 363,
//     cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::is_hashable_data")
//    //</editor-fold>
//    public static class/*struct*/ is_hashable_data extends /**/ integral_constant<boolean, (is_hashable_data<T>.value
//   && is_hashable_data<U>.value
//   && (sizeof(T) + sizeof(U))
//   == sizeof(std.pair<T, U>))> {
//    }
    
    /// \brief Helper to get the hashable data representation for a type.
    /// This variant is enabled when the type itself can be used.
    /*template <typename T> TEMPLATE*/
//    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::get_hashable_data">
//    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 372,
//     cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::get_hashable_data")
//    //</editor-fold>
//    public static </*typename*/ T>  T get_hashable_data(/*const*/ T /*&*/ value) {
//      return value;
//    }

    /// \brief Helper to get the hashable data representation for a type.
    /// This variant is enabled when we must first call hash_value and use the
    /// result as our data.
    /*template <typename T> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::get_hashable_data">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 380,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::get_hashable_data")
    //</editor-fold>
    public static </*typename*/ T>  hash_code get_hashable_data(/*const*/ T /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      assert false :  "declare get_hashable_data(" + 
              value.getClass().getSimpleName() + ") specialization";
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ hash_code /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ string /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ byte /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ short /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ long /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ int /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_data(/*const*/ boolean /*&*/ value) {
      //JAVA: using ::llvm::hash_value;
      return hash_value(value);
    }
    public static hash_code get_hashable_ptr_data(/*const*/ Object /*P &*/ Ptr) {
      //JAVA: using ::llvm::hash_value;
      assert Ptr == null || !(Ptr instanceof NativePointerLike) : "can not use identity hashcode for " + NativeTrace.getIdentityStr(Ptr);
      return hash_value(System.identityHashCode(Ptr));
    }

    
    /// \brief Helper to store data from a value into a buffer and advance the
    /// pointer into that buffer.
    ///
    /// This routine first checks whether there is enough space in the provided
    /// buffer, and if not immediately returns false. If there is space, it
    /// copies the underlying bytes of value into the buffer, advances the
    /// buffer_ptr past the copied bytes, and returns true.
    /*template <typename T> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::store_and_advance">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 394,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::store_and_advance")
    //</editor-fold>
    public static boolean store_and_advance(char$ptr/*char P&*/ buffer_ptr, char$ptr/*char P*/ buffer_end, /*const*/ hash_code /*&*/ value) {
      return store_and_advance(buffer_ptr, buffer_end, value, 
                     0);
    }
    public static boolean store_and_advance(char$ptr/*char P&*/ buffer_ptr, char$ptr/*char P*/ buffer_end, /*const*/ hash_code /*&*/ value, 
                     /*size_t*/int offset/*= 0*/) {
      /*size_t*/int store_size = /*sizeof(value)*/NativeType.BYTES_IN_LONG - offset;
      if ((buffer_ptr.$index() + store_size) > buffer_end.$index()) {
        return false;
      }
      /*const*/
//      char$ptr/*char P*/ value_data = reinterpret_cast_const_char$ptr(/*AddrOf*/ value.value);
      copy_long_to_char$ptr(buffer_ptr, 0, value.value, offset, store_size);
//      memcpy(buffer_ptr, value_data.$add(offset), store_size);      
      buffer_ptr.$inc(store_size);
      return true;
    }

    
    /// \brief Implement the combining of integral values into a hash_code.
    ///
    /// This overload is selected when the value type of the iterator is
    /// integral. Rather than computing a hash_code for each object and then
    /// combining them, this (as an optimization) directly combines the integers.
    /*template <typename InputIteratorT> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_range_impl">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 405,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 409,
     FQN="llvm::hashing::detail::hash_combine_range_impl", NM="Tpl__ZN4llvm7hashing6detail23hash_combine_range_implET_S2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=Tpl__ZN4llvm7hashing6detail23hash_combine_range_implET_S2_")
    //</editor-fold>
    public static hash_code hash_combine_range_impl(char$iterator first, char$iterator last) {
      /*const*//*uint64_t*/long seed = get_execution_seed();
      /*char*/byte buffer[/*64*/] = new$char(64);
      char$ptr buffer_ptr = create_char$ptr(buffer);
      char$ptr buffer_start = $tryConstClone(buffer_ptr);
      char$ptr/*char P*//*const*/ buffer_end = buffer_ptr.$add(array_lengthof(buffer));
      first = $tryClone(first);
      while ($noteq_iter(first, last) && store_and_advance(buffer_ptr, buffer_end, 
              get_hashable_data(first.$star()))) {
        first.$preInc();
      }
      if ($eq_iter(first, last)) {
        return new hash_code(hash_short(buffer_start, buffer_ptr.$sub(buffer_start), seed));
      }
      assert (buffer_ptr.$eq(buffer_end));

      hash_state state = hash_state.create(buffer_start, seed);
      /*size_t*/int length = 64;
      while ($noteq_iter(first, last)) {
        // Fill up the buffer. We don't clear it, which re-mixes the last round
        // when only a partial 64-byte chunk is left.
        buffer_ptr = create_char$ptr(buffer);
        while ($noteq_iter(first, last) && store_and_advance(buffer_ptr, buffer_end, 
            get_hashable_data(first.$star()))) {
          first.$preInc();
        }

        // Rotate the buffer if we did a partial fill in order to simulate doing
        // a mix of the last 64-bytes. That is how the algorithm works when we
        // have a contiguous byte sequence, and we want to emulate that here.
        std.rotate(buffer_start, buffer_ptr, buffer_end);

        // Mix this chunk into the current state.
        state.mix(buffer_start);
        length += buffer_ptr.$sub(buffer_start);
      }
      ;

      return new hash_code(state.finalize(length));
    }
    public static </*typename*/ InputIteratorT> hash_code hash_combine_range_impl(InputIteratorT first, InputIteratorT last) {
      throw new UnsupportedOperationException("Need specialization for " + NativeTrace.getIdentityStr(first));
    }    
    
    public static hash_code hash_combine_range_impl(ulong$iterator<?> first, ulong$iterator<?> last) {
      /*const*//*uint64_t*/long seed = get_execution_seed();
      /*char*/byte buffer[/*64*/] = new$char(64);
      char$ptr buffer_ptr = create_char$ptr(buffer);
      char$ptr buffer_start = $tryConstClone(buffer_ptr);
      char$ptr/*char P*//*const*/ buffer_end = buffer_ptr.$add(array_lengthof(buffer));
      first = $tryClone(first);
      while ($noteq_iter(first, last) && store_and_advance(buffer_ptr, buffer_end, 
              get_hashable_data(first.$star()))) {
        first.$preInc();
      }
      if ($eq_iter(first, last)) {
        return new hash_code(hash_short(buffer_start, buffer_ptr.$sub(buffer_start), seed));
      }
      assert (buffer_ptr.$eq(buffer_end));

      hash_state state = hash_state.create(buffer_start, seed);
      /*size_t*/int length = 64;
      while ($noteq_iter(first, last)) {
        // Fill up the buffer. We don't clear it, which re-mixes the last round
        // when only a partial 64-byte chunk is left.
        buffer_ptr = create_char$ptr(buffer);
        while ($noteq_iter(first, last) && store_and_advance(buffer_ptr, buffer_end, 
            get_hashable_ptr_data(first.$star()))) {
          first.$preInc();
        }

        // Rotate the buffer if we did a partial fill in order to simulate doing
        // a mix of the last 64-bytes. That is how the algorithm works when we
        // have a contiguous byte sequence, and we want to emulate that here.
        std.rotate(buffer_start, buffer_ptr, buffer_end);

        // Mix this chunk into the current state.
        state.mix(buffer_start);
        length += buffer_ptr.$sub(buffer_start);
      }
      ;

      return new hash_code(state.finalize(length));      
    }    
    
    public static </*typename*/ InputIteratorT extends type$iterator<?,?>> hash_code hash_combine_range_ptrs_impl(InputIteratorT first, InputIteratorT last) {
      /*const*//*uint64_t*/long seed = get_execution_seed();
      /*char*/byte buffer[/*64*/] = new$char(64);
      char$ptr buffer_ptr = create_char$ptr(buffer);
      char$ptr buffer_start = $tryConstClone(buffer_ptr);
      char$ptr/*char P*//*const*/ buffer_end = buffer_ptr.$add(array_lengthof(buffer));
      first = $tryClone(first);
      while ($noteq_iter(first, last) && store_and_advance(buffer_ptr, buffer_end, 
              get_hashable_ptr_data(first.$star()))) {
        first.$preInc();
      }
      if ($eq_iter(first, last)) {
        return new hash_code(hash_short(buffer_start, buffer_ptr.$sub(buffer_start), seed));
      }
      assert (buffer_ptr.$eq(buffer_end));

      hash_state state = hash_state.create(buffer_start, seed);
      /*size_t*/int length = 64;
      while ($noteq_iter(first, last)) {
        // Fill up the buffer. We don't clear it, which re-mixes the last round
        // when only a partial 64-byte chunk is left.
        buffer_ptr = create_char$ptr(buffer);
        while ($noteq_iter(first, last) && store_and_advance(buffer_ptr, buffer_end, 
            get_hashable_ptr_data(first.$star()))) {
          first.$preInc();
        }

        // Rotate the buffer if we did a partial fill in order to simulate doing
        // a mix of the last 64-bytes. That is how the algorithm works when we
        // have a contiguous byte sequence, and we want to emulate that here.
        std.rotate(buffer_start, buffer_ptr, buffer_end);

        // Mix this chunk into the current state.
        state.mix(buffer_start);
        length += buffer_ptr.$sub(buffer_start);
      }
      ;

      return new hash_code(state.finalize(length));      
    }    
    
    /// \brief Implement the combining of integral values into a hash_code.
    ///
    /// This overload is selected when the value type of the iterator is integral
    /// and when the input iterator is actually a pointer. Rather than computing
    /// a hash_code for each object and then combining them, this (as an
    /// optimization) directly combines the integers. Also, because the integers
    /// are stored in contiguous memory, this routine avoids copying each value
    /// and directly reads from the underlying memory.
    /*template <typename ValueT> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_range_impl">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 448,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 452,
     FQN="llvm::hashing::detail::hash_combine_range_impl", NM="Tpl__ZN4llvm7hashing6detail23hash_combine_range_implEPT_S3_R_ZTSNSt9enable_ifIXsr16is_hashable_dataIT_EE5valueEN4llvm9hash_codeEE4typeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=Tpl__ZN4llvm7hashing6detail23hash_combine_range_implEPT_S3_R_ZTSNSt9enable_ifIXsr16is_hashable_dataIT_EE5valueEN4llvm9hash_codeEE4typeE")
    //</editor-fold>
    public static /*std::enable_if<is_hashable_data<ValueT>::value, hash_code>::type*/
        hash_code hash_combine_range_impl$HashableData(char$ptr /*P*/ first, char$ptr /*P*/ last) {
      /*const*//*size_t*/int seed = (int) get_execution_seed();
      /*const*/char$ptr/*char P*/ s_begin = $tryClone(first);
      /*const*/char$ptr/*char P*/ s_end = $tryClone(last);
      /*const*//*size_t*/int length = std.distance(s_begin, s_end);
      if ($lesseq_uint(length, 64)) {
        return new hash_code(hash_short(s_begin, length, $uint2ulong(seed)));
      }

      /*const*/char$ptr/*char P*/ s_aligned_end = $tryClone(s_begin.$add((length & ~63)));
      hash_state state = hash_state.create(s_begin, $uint2ulong(seed));
      s_begin.$inc(64);
      while ($noteq_ptr(s_begin, s_aligned_end)) {
        state.mix(s_begin);
        s_begin.$inc(64);
      }
      if (((length & 63) != 0)) {
        state.mix(s_end.$sub(64));
      }

      return new hash_code(state.finalize(length));
    }
    public static /*std::enable_if<is_hashable_data<ValueT>::value, hash_code>::type*/
        hash_code hash_combine_range_impl$HashableData(uint$ptr /*P*/ first, uint$ptr /*P*/ last) {
      assert first.$array() == last.$array();
      uint$memory memory = new uint$mem(first.$array());
      return hash_combine_range_impl$HashableData(
              reinterpret_cast(char$ptr.class, new uint$ptr$heavy(memory, first.$index())),
              reinterpret_cast(char$ptr.class, new uint$ptr$heavy(memory, last.$index()))
      );
    }


    /// \brief Helper class to manage the recursive combining of hash_combine
    /// arguments.
    ///
    /// This class exists to manage the state and various calls involved in the
    /// recursive combining of arguments used in hash_combine. It is particularly
    /// useful at minimizing the code in the recursive calls to ease the pain
    /// caused by a lack of variadic functions.
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 497,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 502,
     FQN = "llvm::hashing::detail::hash_combine_recursive_helper", NM = "_ZN4llvm7hashing6detail29hash_combine_recursive_helperE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail29hash_combine_recursive_helperE")
    //</editor-fold>
    public static class/*struct*/ hash_combine_recursive_helper {
      public /*char*/char$ptr buffer = create_char$ptr(new /*char*/byte [64]);
      public hash_state state;
      public /*const*//*uint64_t*/long seed;
    /*public:*/
      /// \brief Construct a recursive hash combining helper.
      ///
      /// This sets up the state for a recursive hash combine, including getting
      /// the seed and buffer setup.
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::hash_combine_recursive_helper">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 507,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 512,
       FQN = "llvm::hashing::detail::hash_combine_recursive_helper::hash_combine_recursive_helper", NM = "_ZN4llvm7hashing6detail29hash_combine_recursive_helperC1Ev",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail29hash_combine_recursive_helperC1Ev")
      //</editor-fold>
      public hash_combine_recursive_helper() {
        /* : state(), seed(get_execution_seed())*/ 
        //START JInit
        this.state = new hash_state();
        this.seed = get_execution_seed();
        //END JInit
      }


      /// \brief Combine one chunk of data into the current in-flight hash.
      ///
      /// This merges one chunk of data into the hash. First it tries to buffer
      /// the data. If the buffer is full, it hashes the buffer into its
      /// hash_state, empties it, and then merges the new chunk in. This also
      /// handles cases where the data straddles the end of the buffer.
      /*template <typename T> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine_data">
      @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 523,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine_data")
      //</editor-fold>
      public char$ptr/*char P*/ combine_data(/*size_t*/int/*&*/ length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, hash_code data) {
        if (!store_and_advance(buffer_ptr, buffer_end, data)) {
          // Check for skew which prevents the buffer from being packed, and do
          // a partial store into the buffer to fill it. This is only a concern
          // with the variadic combine because that formation can have varying
          // argument types.
          /*size_t*/int partial_store_size = buffer_end.$sub(buffer_ptr);
          memcpy(buffer_ptr, $AddrOf(reinterpret_cast_const_char$ptr(data.value)), partial_store_size);

          // If the store fails, our buffer is full and ready to hash. We have to
          // either initialize the hash state (on the first full buffer) or mix
          // this buffer into the existing hash state. Length tracks the *hashed*
          // length, not the buffered length.
          if (length == 0) {
            state.$assign(state.create(buffer, seed));
            length = 64;
          } else {
            // Mix this chunk into the current state and bump length up by 64.
            state.mix(buffer);
            length += 64;
          }
          // Reset the buffer_ptr to the head of the buffer for the next chunk of
          // data.
          buffer_ptr = buffer;

          // Try again to store into the buffer -- this cannot fail as we only
          // store types smaller than the buffer.
          if (!store_and_advance(buffer_ptr, buffer_end, data, 
              partial_store_size)) {
            abort();
          }
        }
        return buffer_ptr;
      }

      // Manually expanded recursive combining methods. See variadic above for
      // documentation.
      /*template <typename T1, typename T2, typename T3, typename T4, typename T5, typename T6> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 578,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5, /*typename*/ T6, /*typename*/ T7, /*typename*/ T8> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
             /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5, /*const*/ T6 /*&*/ arg6,
             /*const*/ T7 /*&*/ arg7, /*const*/ T8 /*&*/ arg8) {
        assert false : "declare and use combine(....." + 
                ", " + arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ", " + arg3.getClass().getSimpleName() + 
                ", " + arg4.getClass().getSimpleName() + 
                ", " + arg5.getClass().getSimpleName() + 
                ", " + arg6.getClass().getSimpleName() + 
                ", " + arg7.getClass().getSimpleName() + 
                ", " + arg8.getClass().getSimpleName() + 
                ") specialization";        
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5, /*const*/boolean /*&*/ arg6, 
             /*const*/boolean /*&*/ arg7, /*const*/boolean /*&*/ arg8) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
      }

      // Manually expanded recursive combining methods. See variadic above for
      // documentation.
      /*template <typename T1, typename T2, typename T3, typename T4, typename T5, typename T6> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 578,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5, /*typename*/ T6, /*typename*/ T7> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
             /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5, /*const*/ T6 /*&*/ arg6,
             /*const*/ T7 /*&*/ arg7) {
        assert false : "declare and use combine(....." + 
                ", " + arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ", " + arg3.getClass().getSimpleName() + 
                ", " + arg4.getClass().getSimpleName() + 
                ", " + arg5.getClass().getSimpleName() + 
                ", " + arg6.getClass().getSimpleName() + 
                ", " + arg7.getClass().getSimpleName() + 
                ") specialization";        
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6, arg7);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ boolean /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5, /*const*/boolean /*&*/ arg6, /*const*/boolean /*&*/ arg7) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6, arg7);
      }
      
      // Manually expanded recursive combining methods. See variadic above for
      // documentation.
      /*template <typename T1, typename T2, typename T3, typename T4, typename T5, typename T6> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 578,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5, /*typename*/ T6> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
             /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5, /*const*/ T6 /*&*/ arg6) {
        assert false : "declare and use combine(....." + 
                ", " + arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ", " + arg3.getClass().getSimpleName() + 
                ", " + arg4.getClass().getSimpleName() + 
                ", " + arg5.getClass().getSimpleName() + 
                ", " + arg6.getClass().getSimpleName() + 
                ") specialization";        
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5, /*const*/boolean /*&*/ arg6) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ boolean /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5, /*const*/boolean /*&*/ arg6) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
             /*const*/ std.string /*&*/ arg4, /*const*/ std.string /*&*/ arg5, /*const*/ std.string /*&*/ arg6) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5, arg6);
      }

      /*template <typename T1, typename T2, typename T3, typename T4, typename T5> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 585,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
             /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5) {
        assert false : "declare and use combine(....." + 
                ", " + arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ", " + arg3.getClass().getSimpleName() + 
                ", " + arg4.getClass().getSimpleName() + 
                ", " + arg5.getClass().getSimpleName() + 
                ") specialization";
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*char*/byte /*&*/ arg2, /*const*/ /*ushort*/char /*&*/ arg3, 
            /*const*/ hash_code /*&*/ arg4, /*const*/ hash_code /*&*/ arg5) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*char*/byte /*&*/ arg2, /*const*/ /*uint*/int /*&*/ arg3, 
            /*const*/ short /*&*/ arg4, /*const*/ hash_code /*&*/ arg5) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ boolean /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
             /*const*/ std.string /*&*/ arg4, /*const*/ std.string /*&*/ arg5) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4, arg5);
      }
      
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
             /*const*/ std.string /*&*/ arg4) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4);
      }

      /*template <typename T1, typename T2, typename T3, typename T4> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 592,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
        
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
             /*const*/ T4 /*&*/ arg4) {
        assert false : "declare and use combine(....." + 
                ", " + arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ", " + arg3.getClass().getSimpleName() + 
                ", " + arg4.getClass().getSimpleName() + 
                ") specialization";        
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*ushort*/char /*&*/ arg2, 
            /*const*/ hash_code /*&*/ arg3, /*const*/ hash_code /*&*/ arg4) {     
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*uint*/int /*&*/ arg2, 
            /*const*/ short /*&*/ arg3, /*const*/ hash_code /*&*/ arg4) {     
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ boolean /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3, 
             /*const*/ boolean /*&*/ arg4) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
             /*const*/ std.string /*&*/ arg4) {      
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3, arg4);
      }

      /*template <typename T1, typename T2, typename T3> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 599,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2, /*typename*/ T3> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3) {
        assert false : ("declare and use combine(....." + 
                ", " + arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ", " + arg3.getClass().getSimpleName() + 
                ") specialization");
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*char*/byte /*&*/ arg2, /*const*/ /*uint*/int /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }      
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*ushort*/char /*&*/ arg1, /*const*/ hash_code /*&*/ arg2, /*const*/ hash_code /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*uint*/int /*&*/ arg1, /*const*/ short /*&*/ arg2, /*const*/ hash_code /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ string /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ boolean /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      public <T1> hash_code combine_ptr(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*P &*/ arg1, /*const*/ hash_code /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_ptr_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2, arg3);
      }
      
      /*template <typename T1, typename T2> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 605,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1, /*typename*/ T2> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2) {
        assert false : "declare and use combine(....., " + 
                arg1.getClass().getSimpleName() + 
                ", " + arg2.getClass().getSimpleName() + 
                ") specialization";
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*uint*/int /*&*/ arg2) {     
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ short /*&*/ arg1, /*const*/ hash_code /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ boolean /*&*/ arg1, /*const*/ boolean /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ string /*&*/ arg1, /*const*/ boolean /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1, /*const*/ std.string /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ boolean /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ int /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ long /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ string /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }
      public <T/*P*/> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1, /*const*/ hash_code /*&*/ arg2) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end, arg2);
      }

      /*template <typename T1> TEMPLATE*/
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 611,
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hashing::detail::hash_combine_recursive_helper::combine")
      //</editor-fold>
      public </*typename*/ T1> hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ T1 /*&*/ arg1) {
        assert false : "declare and use combine(....., " + 
                arg1.getClass().getSimpleName() + 
                ") specialization";
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ std.string /*&*/ arg1) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ boolean /*&*/ arg1) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ int /*&*/ arg1) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ long /*&*/ arg1) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end);
      }
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end, 
             /*const*/ hash_code /*&*/ arg1) {
        buffer_ptr = combine_data(length, buffer_ptr, buffer_end, get_hashable_data(arg1));
        return combine(length, buffer_ptr, buffer_end);
      }


      /// \brief Base case for recursive, variadic combining.
      ///
      /// The base case when combining arguments recursively is reached when all
      /// arguments have been handled. It flushes the remaining buffer and
      /// constructs a hash_code.
      //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_combine_recursive_helper::combine">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 569,
       old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 623,
       FQN = "llvm::hashing::detail::hash_combine_recursive_helper::combine", NM = "_ZN4llvm7hashing6detail29hash_combine_recursive_helper7combineEjPcS3_",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail29hash_combine_recursive_helper7combineEjPcS3_")
      //</editor-fold>
      public hash_code combine(/*size_t*/int length, char$ptr/*char P*/ buffer_ptr, char$ptr/*char P*/ buffer_end) {
        // Check whether the entire set of values fit in the buffer. If so, we'll
        // use the optimized short hashing routine and skip state entirely.
        if (length == 0) {
          return new hash_code(hash_short(buffer, buffer_ptr.$sub(buffer), seed));
        }

        // Mix the final buffer, rotating it if we did a partial fill in order to
        // simulate doing a mix of the last 64-bytes. That is how the algorithm
        // works when we have a contiguous byte sequence, and we want to emulate
        // that here.
        std.rotate(buffer, buffer_ptr, buffer_end);

        // Mix this chunk into the current state.
        state.mix(buffer);
        length += buffer_ptr.$sub(buffer);

        return new hash_code(state.finalize(length));
      }

    }

    /// \brief Helper to hash the value of a single integer.
    ///
    /// Overloads for smaller integer types are not provided to ensure consistent
    /// behavior in the presence of integral promotions. Essentially,
    /// "hash_value('4')" and "hash_value('0' + 4)" should be the same.
    //<editor-fold defaultstate="collapsed" desc="llvm::hashing::detail::hash_integer_value">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 619,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 722,
     FQN = "llvm::hashing::detail::hash_integer_value", NM = "_ZN4llvm7hashing6detail18hash_integer_valueEy",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm7hashing6detail18hash_integer_valueEy")
    //</editor-fold>
    public static /*inline*/ hash_code hash_integer_value(long/*uint64_t*/ value) {
      // Similar to hash_4to8_bytes but using a seed instead of length.
      /*const*/long/*uint64_t*/ seed = get_execution_seed();
      long/*uint64_t*/ fetch32_L;
      /*uint32_t*/int fetch32_R;
      if (false) {
        /*const*/char$ptr/*char P*/ s = reinterpret_cast_const_char$ptr($AddrOf(value));
        fetch32_L = fetch32(s);
        fetch32_R = fetch32(s.$add(4));
      } else {
        fetch32_L = (int)(value >>> 32);
        fetch32_R = (int)value;
      }
      return new hash_code(hash_16_bytes(seed + (fetch32_L << 3), fetch32_R));
    }

  }
  //} JAVA: end of namespace detail // namespace detail

}
//} JAVA: end of namespace hashing
/*template <typename InputIteratorT> TEMPLATE*/

/// \brief Compute a hash_code for a sequence of values.
///
/// This hashes a sequence of values. It produces the same hash_code as
/// 'hash_combine(a, b, c, ...)', but can run over arbitrary sized sequences
/// and is significantly faster given pointers and types which can be hashed as
/// a sequence of bytes.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine_range">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 487,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine_range")
//</editor-fold>
public static </*typename*/ InputIteratorT> hash_code hash_combine_range(InputIteratorT first, InputIteratorT last) {
  assert !(first instanceof abstract_iterator) : "no hash_combine_range_impl specialization for " + 
          first.getClass().getSimpleName() + ", " + last.getClass().getSimpleName();
  return /*::*/hashing.detail.hash_combine_range_impl(first, last);
}
public static hash_code hash_combine_range(char$iterator first, char$iterator last) {
  return /*::*/ hashing.detail.hash_combine_range_impl((char$iterator) first, (char$iterator) last);
}
public static hash_code hash_combine_range(uint$ptr first, uint$ptr last) {
  return hashing.detail.hash_combine_range_impl$HashableData((uint$ptr) first, (uint$ptr) last);
}
public static hash_code hash_combine_range(char$ptr first, char$ptr last) {
  return hashing.detail.hash_combine_range_impl$HashableData((char$ptr) first, (char$ptr) last);
}
public static hash_code hash_combine_range(ulong$ptr first, ulong$ptr last) {
  return hashing.detail.hash_combine_range_impl((ulong$ptr) first, (ulong$ptr) last);
}
public static hash_code hash_combine_range_ptrs(type$ptr<?> first, type$ptr<?> last) {
  return hashing.detail.hash_combine_range_ptrs_impl(first, last);
}
public static hash_code hash_combine_range(type$ptr<?> first, type$ptr<?> last) {
  throw new UnsupportedOperationException("when [first;end) range contains just pointers, then use hash_combine_range_ptrs method. Otherwise need to have hash_combine_range specialization for values");
}

/*template <typename T1, typename T2, typename T3, typename T4, typename T5, typename T6, typename T7> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 674,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5, /*typename*/ T6, /*typename*/ T7> hash_code hash_combine(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
            /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5, /*const*/ T6 /*&*/ arg6, /*const*/ T7 /*&*/ arg7) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ", " + arg2.getClass().getSimpleName() + 
          ", " + arg3.getClass().getSimpleName() + 
          ", " + arg4.getClass().getSimpleName() + 
          ", " + arg5.getClass().getSimpleName() + 
          ", " + arg6.getClass().getSimpleName() + 
          ", " + arg7.getClass().getSimpleName() + 
          ") specialization";    
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5, arg6);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/std.string /*&*/ arg3, 
            /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5, /*const*/ boolean /*&*/ arg6, /*const*/ boolean /*&*/ arg7, /*const*/ boolean /*&*/ arg8) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
}
/*template <typename T1, typename T2, typename T3, typename T4, typename T5, typename T6> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 674,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5, /*typename*/ T6> hash_code hash_combine(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
            /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5, /*const*/ T6 /*&*/ arg6) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ", " + arg2.getClass().getSimpleName() + 
          ", " + arg3.getClass().getSimpleName() + 
          ", " + arg4.getClass().getSimpleName() + 
          ", " + arg5.getClass().getSimpleName() + 
          ", " + arg6.getClass().getSimpleName() + 
          ") specialization";    
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5, arg6);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/boolean /*&*/ arg3, 
            /*const*/ boolean /*&*/ arg4, /*const*/ boolean /*&*/ arg5, /*const*/ boolean /*&*/ arg6) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5, arg6);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
            /*const*/ std.string /*&*/ arg4, /*const*/ std.string /*&*/ arg5, /*const*/ std.string /*&*/ arg6) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5, arg6);
}

public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ std.string /*&*/ arg2, /*const*/ std.string /*&*/ arg3, 
            /*const*/ std.string /*&*/ arg4) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4);
}

/*template <typename T1, typename T2, typename T3, typename T4, typename T5> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 681,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5> hash_code hash_combine(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
            /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ", " + arg2.getClass().getSimpleName() + 
          ", " + arg3.getClass().getSimpleName() + 
          ", " + arg4.getClass().getSimpleName() + 
          ", " + arg5.getClass().getSimpleName() + 
          ") specialization";  
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5);
}
public static hash_code hash_combine(/*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*char*/byte /*&*/ arg2, /*const*/ /*ushort*/char /*&*/ arg3, 
            /*const*/ hash_code /*&*/ arg4, /*const*/hash_code  /*&*/ arg5) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5);
}
public static hash_code hash_combine(/*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*char*/byte /*&*/ arg2, /*const*/ /*uint*/int /*&*/ arg3, 
            /*const*/ short /*&*/ arg4, /*const*/ hash_code /*&*/ arg5) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4, arg5);
}
public static </*typename*/ T1/*P*/, /*typename*/ T2/*P*/, /*typename*/ T3/*P*/, /*typename*/ T4/*P*/, /*typename*/ T5/*P*/> hash_code hash_combine_ptrs(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
            /*const*/ T4 /*&*/ arg4, /*const*/ T5 /*&*/ arg5) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      hash_value_ptr(arg1), hash_value_ptr(arg2), hash_value_ptr(arg3), hash_value_ptr(arg4), hash_value_ptr(arg5));
}

/*template <typename T1, typename T2, typename T3, typename T4> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 688,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4> hash_code hash_combine(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3, 
            /*const*/ T4 /*&*/ arg4) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ", " + arg2.getClass().getSimpleName() + 
          ", " + arg3.getClass().getSimpleName() + 
          ", " + arg4.getClass().getSimpleName() + 
          ") specialization";  
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), 
      arg1, arg2, arg3, arg4);
}

/*template <typename T1, typename T2, typename T3> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 695,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1, /*typename*/ T2, /*typename*/ T3> hash_code hash_combine(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2, /*const*/ T3 /*&*/ arg3) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ", " + arg2.getClass().getSimpleName() + 
          ", " + arg3.getClass().getSimpleName() + 
          ") specialization";
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2, arg3);
}
public static hash_code hash_combine(/*const*/ /*char*/byte /*&*/ arg1, /*const*/ /*char*/byte /*&*/ arg2, /*const*/ /*uint*/int /*&*/ arg3) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2, arg3);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ string /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2, arg3);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ boolean /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2, arg3);
}
public static </*typename*/ T1> hash_code hash_combine_ptr(/*const*/ T1 /*P &*/ arg1, /*const*/ hash_code /*&*/ arg2, /*const*/ boolean /*&*/ arg3) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine_ptr(0, helper.buffer, helper.buffer.$add(64), arg1, arg2, arg3);
}

/*template <typename T1, typename T2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 700,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1, /*typename*/ T2> hash_code hash_combine(/*const*/ T1 /*&*/ arg1, /*const*/ T2 /*&*/ arg2) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ", " + arg2.getClass().getSimpleName() + 
          ") specialization";  
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ boolean /*&*/ arg2) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ int /*&*/ arg2) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ long /*&*/ arg2) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1, /*const*/ string /*&*/ arg2) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1, arg2);
}
public static hash_code hash_combine(/*const*/ std.string /*&*/ arg1, /*const*/ std.string /*&*/ arg2) {
  hash_code hash = hashing.detail.hash_combine_range_impl$HashableData(arg1.begin(), arg1.end());
  return hash_combine(hash, arg2);
}
public static hash_code hash_combine(/*const*/ long /*&*/ arg1, /*const*/ long /*&*/ arg2) {
  hash_code hash = hash_combine(arg1);
  return hash_combine(hash, arg2);
}

/*template <typename T1> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 705,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -filter=llvm::hash_combine")
//</editor-fold>
public static </*typename*/ T1> hash_code hash_combine(/*const*/ T1 /*&*/ arg1) {
  assert false : "declare and use hash_combine(....." + 
          ", " + arg1.getClass().getSimpleName() + 
          ") specialization";  
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1);
}
public static hash_code hash_combine(/*const*/ /*uint64*/long /*&*/ arg1) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), arg1);
}
public static hash_code hash_combine(/*const*/ hash_code /*&*/ arg1) {
  return arg1;
}
public static <T /*P*/, U/*P*/> hash_code hash_combine_ptrs(/*const*/ T /*&*/ ptr1, /*const*/ U /*&*/ ptr2) {
  /*::*/hash_combine_recursive_helper helper/*J*/= new /*::*/hash_combine_recursive_helper();
  return helper.combine(0, helper.buffer, helper.buffer.$add(64), hash_value_ptr(ptr1), hash_value_ptr(ptr2));
}

} // END OF class llvm
