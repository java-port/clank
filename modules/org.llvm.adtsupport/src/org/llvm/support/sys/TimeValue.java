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

package org.llvm.support.sys;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std_time.gettimeofday;
import org.clank.java.std_time.timeval;
import static org.clank.support.Unsigned.*;

/// This class is used where a precise fixed point in time is required. The
/// range of TimeValue spans many hundreds of billions of years both past and
/// present.  The precision of TimeValue is to the nanosecond. However, the
/// actual precision of its values will be determined by the resolution of
/// the system clock. The TimeValue class is used in conjunction with several
/// other lib/System interfaces to specify the time at which a call should
/// timeout, etc.
/// @since 1.4
/// @brief Provides an abstraction for a fixed point in time.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 31,
 FQN="llvm::sys::TimeValue", NM="_ZN4llvm3sys9TimeValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValueE")
//</editor-fold>
public class TimeValue implements Native.NativeComparable<TimeValue> {
/*public:*/
  
  /// A constant TimeValue representing the smallest time
  /// value permissible by the class. MinTime is some point
  /// in the distant past, about 300 billion years BCE.
  /// @brief The smallest possible time value.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::MinTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 41,
   FQN="llvm::sys::TimeValue::MinTime", NM="_ZN4llvm3sys9TimeValue7MinTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue7MinTimeEv")
  //</editor-fold>
  public static TimeValue MinTime() {
    return new TimeValue(INT64_MIN, 0);
  }

  
  /// A constant TimeValue representing the largest time
  /// value permissible by the class. MaxTime is some point
  /// in the distant future, about 300 billion years AD.
  /// @brief The largest possible time value.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::MaxTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 49,
   FQN="llvm::sys::TimeValue::MaxTime", NM="_ZN4llvm3sys9TimeValue7MaxTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue7MaxTimeEv")
  //</editor-fold>
  public static TimeValue MaxTime() {
    return new TimeValue(INT64_MAX, 0);
  }

  
  /// A constant TimeValue representing the base time,
  /// or zero time of 00:00:00 (midnight) January 1st, 2000.
  /// @brief 00:00:00 Jan 1, 2000 UTC.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::ZeroTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 56,
   FQN="llvm::sys::TimeValue::ZeroTime", NM="_ZN4llvm3sys9TimeValue8ZeroTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue8ZeroTimeEv")
  //</editor-fold>
  public static TimeValue ZeroTime() {
    return new TimeValue(0, 0);
  }

  
  /// A constant TimeValue for the Posix base time which is
  /// 00:00:00 (midnight) January 1st, 1970.
  /// @brief 00:00:00 Jan 1, 1970 UTC.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::PosixZeroTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 63,
   FQN="llvm::sys::TimeValue::PosixZeroTime", NM="_ZN4llvm3sys9TimeValue13PosixZeroTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue13PosixZeroTimeEv")
  //</editor-fold>
  public static TimeValue PosixZeroTime() {
    return new TimeValue(PosixZeroTimeSeconds, 0);
  }

  
  /// A constant TimeValue for the Win32 base time which is
  /// 00:00:00 (midnight) January 1st, 1601.
  /// @brief 00:00:00 Jan 1, 1601 UTC.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::Win32ZeroTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 70,
   FQN="llvm::sys::TimeValue::Win32ZeroTime", NM="_ZN4llvm3sys9TimeValue13Win32ZeroTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue13Win32ZeroTimeEv")
  //</editor-fold>
  public static TimeValue Win32ZeroTime() {
    return new TimeValue(Win32ZeroTimeSeconds, 0);
  }

/*public:*/
  
  /// @}
  /// @name Types
  /// @{
  /*typedef int64_t SecondsType*/; ///< Type used for representing seconds.
  /*typedef int32_t NanoSecondsType*/; ///< Type used for representing nanoseconds.
  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::TimeConversions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 81,
   FQN="llvm::sys::TimeValue::TimeConversions", NM="_ZN4llvm3sys9TimeValue15TimeConversionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue15TimeConversionsE")
  //</editor-fold>
  public enum TimeConversions implements Native.ComparableLower {
    NANOSECONDS_PER_SECOND(1000000000), ///< One Billion
    MICROSECONDS_PER_SECOND(1000000), ///< One Million
    MILLISECONDS_PER_SECOND(1000), ///< One Thousand
    NANOSECONDS_PER_MICROSECOND(1000), ///< One Thousand
    NANOSECONDS_PER_MILLISECOND(1000000), ///< One Million
    NANOSECONDS_PER_WIN32_TICK(100); ///< Win32 tick is 10^7 Hz (10ns)

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TimeConversions valueOf(int val) {
      TimeConversions out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TimeConversions[] VALUES;
      private static final TimeConversions[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TimeConversions kind : TimeConversions.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TimeConversions[min < 0 ? (1-min) : 0];
        VALUES = new TimeConversions[max >= 0 ? (1+max) : 0];
        for (TimeConversions kind : TimeConversions.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TimeConversions(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TimeConversions)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TimeConversions)obj).value);}
    //</editor-fold>
  };
/*public:*/
  /// \brief Default construct a time value, initializing to ZeroTime.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::TimeValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 95,
   FQN="llvm::sys::TimeValue::TimeValue", NM="_ZN4llvm3sys9TimeValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValueC1Ev")
  //</editor-fold>
  public TimeValue() {
    /* : seconds_(0), nanos_(0)*/ 
    //START JInit
    this.seconds_ = 0;
    this.nanos_ = 0;
    //END JInit
  }

  
  /// Caller provides the exact value in seconds and nanoseconds. The
  /// \p nanos argument defaults to zero for convenience.
  /// @brief Explicit constructor
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::TimeValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 100,
   FQN="llvm::sys::TimeValue::TimeValue", NM="_ZN4llvm3sys9TimeValueC1Exi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValueC1Exi")
  //</editor-fold>
  public /*explicit*/ TimeValue(long/*int64_t*/ seconds) {
    this(seconds, 0);
  }
  public /*explicit*/ TimeValue(long/*int64_t*/ seconds, int/*int32_t*/ nanos/*= 0*/) {
    /* : seconds_(seconds), nanos_(nanos)*/ 
    //START JInit
    this.seconds_ = seconds;
    this.nanos_ = nanos;
    //END JInit
    this.normalize();
  }

  
  /// Caller provides the exact value as a double in seconds with the
  /// fractional part representing nanoseconds.
  /// @brief Double Constructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::TimeValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 106,
   FQN="llvm::sys::TimeValue::TimeValue", NM="_ZN4llvm3sys9TimeValueC1Ed",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValueC1Ed")
  //</editor-fold>
  public /*explicit*/ TimeValue(double new_time) {
    /* : seconds_(0), nanos_(0)*/ 
    //START JInit
    this.seconds_ = 0;
    this.nanos_ = 0;
    //END JInit
    long/*int64_t*/ integer_part = ((/*static_cast*/long/*int64_t*/)(new_time));
    seconds_ = integer_part;
    nanos_ = ((/*static_cast*/int/*int32_t*/)((new_time
       - ((/*static_cast*/double)(integer_part))) * TimeConversions.NANOSECONDS_PER_SECOND.getValue()));
    this.normalize();
  }

  
  /// This is a static constructor that returns a TimeValue that represents
  /// the current time.
  /// @brief Creates a TimeValue with the current time (UTC).
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::now">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Unix/TimeValue.inc", line = 36,
   FQN="llvm::sys::TimeValue::now", NM="_ZN4llvm3sys9TimeValue3nowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue3nowEv")
  //</editor-fold>
  public static TimeValue now() {
     timeval the_time/*J*/= new  timeval();
    ($AddrOf(the_time)).tv_sec = ($AddrOf(the_time)).tv_usec = 0;
    if (0 != /*::*/gettimeofday($AddrOf(the_time), null)) {
      // This is *really* unlikely to occur because the only gettimeofday
      // errors concern the timezone parameter which we're passing in as 0.
      // In the unlikely case it does happen, just return MinTime, no error
      // message needed.
      return MinTime();
    }
    
    return new TimeValue(((/*static_cast*/long/*int64_t*/)(the_time.tv_sec
           + PosixZeroTimeSeconds)), 
        ((/*static_cast*/int/*int32_t*/)(the_time.tv_usec
           * TimeConversions.NANOSECONDS_PER_MICROSECOND.getValue())));
  }

/*public:*/
  /// Add \p that to \p this.
  /// @returns this
  /// @brief Incrementing assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator+=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 127,
   FQN="llvm::sys::TimeValue::operator+=", NM="_ZN4llvm3sys9TimeValuepLERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValuepLERKS1_")
  //</editor-fold>
  public TimeValue /*&*/ $addassign(/*const*/ TimeValue /*&*/ that) {
    this.seconds_ += that.seconds_;
    this.nanos_ += that.nanos_;
    this.normalize();
    return /*Deref*/this;
  }

  
  /// Subtract \p that from \p this.
  /// @returns this
  /// @brief Decrementing assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator-=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 137,
   FQN="llvm::sys::TimeValue::operator-=", NM="_ZN4llvm3sys9TimeValuemIERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValuemIERKS1_")
  //</editor-fold>
  public TimeValue /*&*/ $minusassign(/*const*/ TimeValue /*&*/ that) {
    this.seconds_ -= that.seconds_;
    this.nanos_ -= that.nanos_;
    this.normalize();
    return /*Deref*/this;
  }

  
  /// Determine if \p this is less than \p that.
  /// @returns True iff *this < that.
  /// @brief True if this < that.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 147,
   FQN="llvm::sys::TimeValue::operator<", NM="_ZNK4llvm3sys9TimeValueltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValueltERKS1_")
  //</editor-fold>
  public int $less(/*const*/ TimeValue /*&*/ that) /*const*/ {
    return that.$greater(/*Deref*/this);
  }

  
  /// Determine if \p this is greather than \p that.
  /// @returns True iff *this > that.
  /// @brief True if this > that.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 152,
   FQN="llvm::sys::TimeValue::operator>", NM="_ZNK4llvm3sys9TimeValuegtERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValuegtERKS1_")
  //</editor-fold>
  public int $greater(/*const*/ TimeValue /*&*/ that) /*const*/ {
    if (this.seconds_ > that.seconds_) {
      return 1;
    } else if (this.seconds_ == that.seconds_) {
      if (this.nanos_ > that.nanos_) {
        return 1;
      }
    }
    return 0;
  }

  
  /// Determine if \p this is less than or equal to \p that.
  /// @returns True iff *this <= that.
  /// @brief True if this <= that.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator<=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 164,
   FQN="llvm::sys::TimeValue::operator<=", NM="_ZNK4llvm3sys9TimeValueleERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValueleERKS1_")
  //</editor-fold>
  public int $lesseq(/*const*/ TimeValue /*&*/ that) /*const*/ {
    return that.$greatereq(/*Deref*/this);
  }

  
  /// Determine if \p this is greater than or equal to \p that.
  /// @returns True iff *this >= that.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator>=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 168,
   FQN="llvm::sys::TimeValue::operator>=", NM="_ZNK4llvm3sys9TimeValuegeERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValuegeERKS1_")
  //</editor-fold>
  public int $greatereq(/*const*/ TimeValue /*&*/ that) /*const*/ {
    if (this.seconds_ > that.seconds_) {
      return 1;
    } else if (this.seconds_ == that.seconds_) {
      if (this.nanos_ >= that.nanos_) {
        return 1;
      }
    }
    return 0;
  }

  
  /// Determines if two TimeValue objects represent the same moment in time.
  /// @returns True iff *this == that.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator==">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 179,
   FQN="llvm::sys::TimeValue::operator==", NM="_ZNK4llvm3sys9TimeValueeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValueeqERKS1_")
  //</editor-fold>
  public boolean $eq(/*const*/ TimeValue /*&*/ that) /*const*/ {
    return ((this.seconds_ == that.seconds_)
       && (this.nanos_ == that.nanos_));
  }

  
  /// Determines if two TimeValue objects represent times that are not the
  /// same.
  /// @returns True iff *this != that.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 187,
   FQN="llvm::sys::TimeValue::operator!=", NM="_ZNK4llvm3sys9TimeValueneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValueneERKS1_")
  //</editor-fold>
  public boolean $noteq(/*const*/ TimeValue /*&*/ that) /*const*/ {
    return !/*Deref*/this.$eq(that);
  }

  
  /// Adds two TimeValue objects together.
  /// @returns The sum of the two operands as a new TimeValue
  /// @brief Addition operator.
  /*friend TimeValue operator+(const TimeValue &tv1, const TimeValue &tv2)*/
  
  /// Subtracts two TimeValue objects.
  /// @returns The difference of the two operands as a new TimeValue
  /// @brief Subtraction operator.
  /*friend TimeValue operator-(const TimeValue &tv1, const TimeValue &tv2)*/
/*public:*/
  
  /// Returns only the seconds component of the TimeValue. The nanoseconds
  /// portion is ignored. No rounding is performed.
  /// @brief Retrieve the seconds component
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::seconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 207,
   FQN="llvm::sys::TimeValue::seconds", NM="_ZNK4llvm3sys9TimeValue7secondsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue7secondsEv")
  //</editor-fold>
  public long/*int64_t*/ seconds() /*const*/ {
    return seconds_;
  }

  
  /// Returns only the nanoseconds component of the TimeValue. The seconds
  /// portion is ignored.
  /// @brief Retrieve the nanoseconds component.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::nanoseconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 212,
   FQN="llvm::sys::TimeValue::nanoseconds", NM="_ZNK4llvm3sys9TimeValue11nanosecondsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue11nanosecondsEv")
  //</editor-fold>
  public int/*int32_t*/ nanoseconds() /*const*/ {
    return nanos_;
  }

  
  /// Returns only the fractional portion of the TimeValue rounded down to the
  /// nearest microsecond (divide by one thousand).
  /// @brief Retrieve the fractional part as microseconds;
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::microseconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 217,
   FQN="llvm::sys::TimeValue::microseconds", NM="_ZNK4llvm3sys9TimeValue12microsecondsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue12microsecondsEv")
  //</editor-fold>
  public /*uint32_t*/int microseconds() /*const*/ {
    return nanos_ / TimeConversions.NANOSECONDS_PER_MICROSECOND.getValue();
  }

  
  /// Returns only the fractional portion of the TimeValue rounded down to the
  /// nearest millisecond (divide by one million).
  /// @brief Retrieve the fractional part as milliseconds;
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::milliseconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 224,
   FQN="llvm::sys::TimeValue::milliseconds", NM="_ZNK4llvm3sys9TimeValue12millisecondsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue12millisecondsEv")
  //</editor-fold>
  public /*uint32_t*/int milliseconds() /*const*/ {
    return nanos_ / TimeConversions.NANOSECONDS_PER_MILLISECOND.getValue();
  }

  
  /// Returns the TimeValue as a number of microseconds. Note that the value
  /// returned can overflow because the range of a uint64_t is smaller than
  /// the range of a TimeValue. Nevertheless, this is useful on some operating
  /// systems and is therefore provided.
  /// @brief Convert to a number of microseconds (can overflow)
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::usec">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 233,
   FQN="llvm::sys::TimeValue::usec", NM="_ZNK4llvm3sys9TimeValue4usecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue4usecEv")
  //</editor-fold>
  public long/*uint64_t*/ usec() /*const*/ {
    return seconds_ * TimeConversions.MICROSECONDS_PER_SECOND.getValue()
       + (nanos_ / TimeConversions.NANOSECONDS_PER_MICROSECOND.getValue());
  }

  
  /// Returns the TimeValue as a number of milliseconds. Note that the value
  /// returned can overflow because the range of a uint64_t is smaller than
  /// the range of a TimeValue. Nevertheless, this is useful on some operating
  /// systems and is therefore provided.
  /// @brief Convert to a number of milliseconds (can overflow)
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::msec">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 243,
   FQN="llvm::sys::TimeValue::msec", NM="_ZNK4llvm3sys9TimeValue4msecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue4msecEv")
  //</editor-fold>
  public long/*uint64_t*/ msec() /*const*/ {
    return seconds_ * TimeConversions.MILLISECONDS_PER_SECOND.getValue()
       + (nanos_ / TimeConversions.NANOSECONDS_PER_MILLISECOND.getValue());
  }

  
  /// Converts the TimeValue into the corresponding number of seconds
  /// since the epoch (00:00:00 Jan 1,1970).
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::toEpochTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 250,
   FQN="llvm::sys::TimeValue::toEpochTime", NM="_ZNK4llvm3sys9TimeValue11toEpochTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue11toEpochTimeEv")
  //</editor-fold>
  public long/*uint64_t*/ toEpochTime() /*const*/ {
    return seconds_ - PosixZeroTimeSeconds;
  }

  
  /// Converts the TimeValue into the corresponding number of "ticks" for
  /// Win32 platforms, correcting for the difference in Win32 zero time.
  /// @brief Convert to Win32's FILETIME
  /// (100ns intervals since 00:00:00 Jan 1, 1601 UTC)
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::toWin32Time">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 258,
   FQN="llvm::sys::TimeValue::toWin32Time", NM="_ZNK4llvm3sys9TimeValue11toWin32TimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue11toWin32TimeEv")
  //</editor-fold>
  public long/*uint64_t*/ toWin32Time() /*const*/ {
    long/*uint64_t*/ result = (long/*uint64_t*/)10000000 * (seconds_ - Win32ZeroTimeSeconds);
    result += $int2ullong(nanos_ / TimeConversions.NANOSECONDS_PER_WIN32_TICK.getValue());
    return result;
  }

  
  /// Provides the seconds and nanoseconds as results in its arguments after
  /// correction for the Posix zero time.
  /// @brief Convert to timespec time (ala POSIX.1b)
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::getTimespecTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 267,
   FQN="llvm::sys::TimeValue::getTimespecTime", NM="_ZNK4llvm3sys9TimeValue15getTimespecTimeERyRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue15getTimespecTimeERyRj")
  //</editor-fold>
  public void getTimespecTime(ulong$ref/*uint64_t &*/ seconds, /*uint32_t &*/uint$ref nanos) /*const*/ {
    seconds.$set(seconds_ - PosixZeroTimeSeconds);
    nanos.$set(nanos_);
  }

  
  /// Provides conversion of the TimeValue into a readable time & date.
  /// @returns std::string containing the readable time value
  /// @brief Convert time to a string.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::str">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/TimeValue.inc", line = 24,
   FQN="llvm::sys::TimeValue::str", NM="_ZNK4llvm3sys9TimeValue3strEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZNK4llvm3sys9TimeValue3strEv")
  //</editor-fold>
  public std.string str() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// The seconds component of the TimeValue is set to \p sec without
  /// modifying the nanoseconds part.  This is useful for whole second
  /// arithmetic.
  /// @brief Set the seconds component.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::seconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 285,
   FQN="llvm::sys::TimeValue::seconds", NM="_ZN4llvm3sys9TimeValue7secondsEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue7secondsEx")
  //</editor-fold>
  public void seconds(long/*int64_t*/ sec) {
    this.seconds_ = sec;
    this.normalize();
  }

  
  /// The nanoseconds component of the TimeValue is set to \p nanos without
  /// modifying the seconds part. This is useful for basic computations
  /// involving just the nanoseconds portion. Note that the TimeValue will be
  /// normalized after this call so that the fractional (nanoseconds) portion
  /// will have the smallest equivalent value.
  /// @brief Set the nanoseconds component using a number of nanoseconds.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::nanoseconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 296,
   FQN="llvm::sys::TimeValue::nanoseconds", NM="_ZN4llvm3sys9TimeValue11nanosecondsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue11nanosecondsEi")
  //</editor-fold>
  public void nanoseconds(int/*int32_t*/ nanos) {
    this.nanos_ = nanos;
    this.normalize();
  }

  
  /// The seconds component remains unchanged.
  /// @brief Set the nanoseconds component using a number of microseconds.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::microseconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 303,
   FQN="llvm::sys::TimeValue::microseconds", NM="_ZN4llvm3sys9TimeValue12microsecondsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue12microsecondsEi")
  //</editor-fold>
  public void microseconds(int/*int32_t*/ micros) {
    this.nanos_ = micros * TimeConversions.NANOSECONDS_PER_MICROSECOND.getValue();
    this.normalize();
  }

  
  /// The seconds component remains unchanged.
  /// @brief Set the nanoseconds component using a number of milliseconds.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::milliseconds">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 310,
   FQN="llvm::sys::TimeValue::milliseconds", NM="_ZN4llvm3sys9TimeValue12millisecondsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue12millisecondsEi")
  //</editor-fold>
  public void milliseconds(int/*int32_t*/ millis) {
    this.nanos_ = millis * TimeConversions.NANOSECONDS_PER_MILLISECOND.getValue();
    this.normalize();
  }

  
  /// @brief Converts from microsecond format to TimeValue format
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::usec">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 316,
   FQN="llvm::sys::TimeValue::usec", NM="_ZN4llvm3sys9TimeValue4usecEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue4usecEx")
  //</editor-fold>
  public void usec(long/*int64_t*/ microseconds) {
    this.seconds_ = microseconds / TimeConversions.MICROSECONDS_PER_SECOND.getValue();
    this.nanos_ = ((int/*int32_t*/)(microseconds % TimeConversions.MICROSECONDS_PER_SECOND.getValue()))
       * TimeConversions.NANOSECONDS_PER_MICROSECOND.getValue();
    this.normalize();
  }

  
  /// @brief Converts from millisecond format to TimeValue format
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::msec">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 324,
   FQN="llvm::sys::TimeValue::msec", NM="_ZN4llvm3sys9TimeValue4msecEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue4msecEx")
  //</editor-fold>
  public void msec(long/*int64_t*/ milliseconds) {
    this.seconds_ = milliseconds / TimeConversions.MILLISECONDS_PER_SECOND.getValue();
    this.nanos_ = ((int/*int32_t*/)(milliseconds % TimeConversions.MILLISECONDS_PER_SECOND.getValue()))
       * TimeConversions.NANOSECONDS_PER_MILLISECOND.getValue();
    this.normalize();
  }

  
  /// Converts the \p seconds argument from PosixTime to the corresponding
  /// TimeValue and assigns that value to \p this.
  /// @brief Convert seconds form PosixTime to TimeValue
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::fromEpochTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 334,
   FQN="llvm::sys::TimeValue::fromEpochTime", NM="_ZN4llvm3sys9TimeValue13fromEpochTimeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue13fromEpochTimeEx")
  //</editor-fold>
  public void fromEpochTime(long/*int64_t*/ seconds) {
    seconds_ = seconds + PosixZeroTimeSeconds;
    nanos_ = 0;
    this.normalize();
  }

  
  /// Converts the \p win32Time argument from Windows FILETIME to the
  /// corresponding TimeValue and assigns that value to \p this.
  /// @brief Convert seconds form Windows FILETIME to TimeValue
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::fromWin32Time">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 343,
   FQN="llvm::sys::TimeValue::fromWin32Time", NM="_ZN4llvm3sys9TimeValue13fromWin32TimeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue13fromWin32TimeEy")
  //</editor-fold>
  public void fromWin32Time(long/*uint64_t*/ win32Time) {
    this.seconds_ = win32Time / 10000000 + Win32ZeroTimeSeconds;
    this.nanos_ = ((int/*int32_t*/)($ullong2int(win32Time % 10000000L))) * 100;
  }

/*private:*/
  /// This causes the values to be represented so that the fractional
  /// part is minimized, possibly incrementing the seconds part.
  /// @brief Normalize to canonical form.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::normalize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp", line = 26,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp", old_line = 25,
   FQN="llvm::sys::TimeValue::normalize", NM="_ZN4llvm3sys9TimeValue9normalizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValue9normalizeEv")
  //</editor-fold>
  /*friend*/ public/*private*/ void normalize() {
    if (nanos_ >= TimeConversions.NANOSECONDS_PER_SECOND.getValue()) {
      do {
        seconds_++;
        nanos_ -= TimeConversions.NANOSECONDS_PER_SECOND.getValue();
      } while (nanos_ >= TimeConversions.NANOSECONDS_PER_SECOND.getValue());
    } else if (nanos_ <= -TimeConversions.NANOSECONDS_PER_SECOND.getValue()) {
      do {
        seconds_--;
        nanos_ += TimeConversions.NANOSECONDS_PER_SECOND.getValue();
      } while (nanos_ <= -TimeConversions.NANOSECONDS_PER_SECOND.getValue());
    }
    if (seconds_ >= 1 && nanos_ < 0) {
      seconds_--;
      nanos_ += TimeConversions.NANOSECONDS_PER_SECOND.getValue();
    } else if (seconds_ < 0 && nanos_ > 0) {
      seconds_++;
      nanos_ -= TimeConversions.NANOSECONDS_PER_SECOND.getValue();
    }
  }

/*private:*/
  /// Store the values as a <timeval>.
  /*friend*/ public/*private*/ long/*int64_t*/ seconds_; ///< Stores the seconds part of the TimeVal
  /*friend*/ public/*private*/ int/*int32_t*/ nanos_; ///< Stores the nanoseconds part of the TimeVal
  
  private static /*const*/long/*int64_t*/ PosixZeroTimeSeconds = -946684800;
  private static /*const*/long/*int64_t*/ Win32ZeroTimeSeconds = -12591158400L/*ULL*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::TimeValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 31,
   FQN="llvm::sys::TimeValue::TimeValue", NM="_ZN4llvm3sys9TimeValueC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sys9TimeValueC1EOS1_")
  //</editor-fold>
  public /*inline*/ TimeValue(JD$Move _dparam, TimeValue /*&&*/$Prm0) {
    /* : seconds_(static_cast<TimeValue &&>().seconds_), nanos_(static_cast<TimeValue &&>().nanos_)*/ 
    //START JInit
    this.seconds_ = $Prm0.seconds_;
    this.nanos_ = $Prm0.nanos_;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::TimeValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 31,
   FQN="llvm::sys::TimeValue::TimeValue", NM="_ZN4llvm3sys9TimeValueC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm3sys9TimeValueC1ERKS1_")
  //</editor-fold>
  public /*inline*/ TimeValue(/*const*/ TimeValue /*&*/ $Prm0) {
    /* : seconds_(.seconds_), nanos_(.nanos_)*/ 
    //START JInit
    this.seconds_ = $Prm0.seconds_;
    this.nanos_ = $Prm0.nanos_;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 31,
   FQN="llvm::sys::TimeValue::operator=", NM="_ZN4llvm3sys9TimeValueaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm3sys9TimeValueaSERKS1_")
  //</editor-fold>
  public /*inline*/ TimeValue /*&*/ $assign(/*const*/ TimeValue /*&*/ $Prm0) {
    this.seconds_ = $Prm0.seconds_;
    this.nanos_ = $Prm0.nanos_;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::TimeValue::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 31,
   FQN="llvm::sys::TimeValue::operator=", NM="_ZN4llvm3sys9TimeValueaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm3sys9TimeValueaSEOS1_")
  //</editor-fold>
  public /*inline*/ TimeValue /*&*/ $assignMove(TimeValue /*&&*/$Prm0) {
    this.seconds_ = $Prm0.seconds_;
    this.nanos_ = $Prm0.nanos_;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "seconds_=" + seconds_ // NOI18N
              + ", nanos_=" + nanos_; // NOI18N
  }
/// @}
}
