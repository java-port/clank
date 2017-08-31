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
import static org.clank.support.Native.$AddrOf;
import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.aliases.*;

/*template <typename T, typename R = T> TEMPLATE*/

/// \brief A switch()-like statement whose cases are string literals.
///
/// The StringSwitch class is a simple form of a switch() statement that
/// determines whether the given string matches one of the given string
/// literals. The template type parameter \p T is the type of the value that
/// will be returned from the string-switch expression. For example,
/// the following code switches on the name of a color in \c argv[i]:
///
/// \code
/// Color color = StringSwitch<Color>(argv[i])
///   .Case("red", Red)
///   .Case("orange", Orange)
///   .Case("yellow", Yellow)
///   .Case("green", Green)
///   .Case("blue", Blue)
///   .Case("indigo", Indigo)
///   .Cases("violet", "purple", Violet)
///   .Default(UnknownColor);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 42,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", old_line = 41,
 FQN = "llvm::StringSwitch", NM = "_ZN4llvm12StringSwitchE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN4llvm12StringSwitchE")
//</editor-fold>
public class StringSwitchInt/*<typename T, typename R = T>*/  {
  /// \brief The string we are matching.
  private final StringRef Str;
  
  /// \brief The pointer to the result of this switch statement, once known,
  /// null before that.
  private /*const*/int /*P*/ Result;
  private /*const*/boolean hasResult = false;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::StringSwitch<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", old_line = 51,
   FQN = "llvm::StringSwitch::StringSwitch<T, R>", NM = "_ZN4llvm12StringSwitchC1ENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN4llvm12StringSwitchC1ENS_9StringRefE")
  //</editor-fold>
  public /*explicit*/ StringSwitchInt(StringRef S) {
    /* : Str(S), Result(0)*/ 
    //START JInit
    this.Str = S;
    this.Result = 0;
    //END JInit
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*explicit*/ StringSwitchInt(std.string S) {
    this(new StringRef(S));
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*explicit*/ StringSwitchInt(char$ptr S) {
    this(new StringRef(S));
  }
  
  /*template <unsigned int N> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::Case">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 55,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::Case")
  //</editor-fold>
  public StringSwitchInt /*&*/ Case(int StrLen, String ConstStr, /*const*/int /*&*/ Value) {
    assert ConstStr.length() + 1 == StrLen : "Must be the same length as " + (StrLen - 1) + "but [" + ConstStr +"] == " + ConstStr.length();
    return Case(ConstStr, Value);
  }
  public StringSwitchInt /*&*/ Case(String S, /*const*/int /*&*/ Value) {
    if (hasResult == false && Str.$equals(S)) {
      Result = $AddrOf(Value);
      hasResult =  true;
    }
    
    return /*Deref*/this;
  }

  /*template <unsigned int N> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::EndsWith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 65,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::EndsWith")
  //</editor-fold>
  public StringSwitchInt /*&*/ EndsWith(String S, /*const*/int /*&*/ Value) {
    if (hasResult == false && Str.endswith(S)) {
      Result = $AddrOf(Value);
      hasResult =  true;
    }
    
    return /*Deref*/this;
  }

  /*template <unsigned int N> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::StartsWith">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 75,
   optimized = Converted.Optimization.VALUE_TYPE,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::StartsWith")
  //</editor-fold>
  public StringSwitchInt /*&*/ StartsWith(String S, /*const*/int /*&*/ Value) {
    if (hasResult == false && Str.startswith(S)) {
      Result = $AddrOf(Value);
      hasResult =  true;
    }
    
    return /*Deref*/this;
  }

  /*template <unsigned int N0, unsigned int N1> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::Cases">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 85,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::Cases")
  //</editor-fold>
  public StringSwitchInt /*&*/ Cases(int S0Len, int S1Len, String S0, String S1, /*const*/int /*&*/ Value) {
    return Case(S0Len, S0, Value).Case(S1Len, S1, Value);
  }
  public StringSwitchInt /*&*/ Cases(String S0, String S1, /*const*/int /*&*/ Value) {
    return Case(S0, Value).Case(S1, Value);
  }

  /*template <unsigned int N0, unsigned int N1, unsigned int N2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::Cases">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 91,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::Cases")
  //</editor-fold>
  public StringSwitchInt /*&*/ Cases(String S0, String S1, String S2, /*const*/int /*&*/ Value) {
    return Case(S0, Value).Case(S1, Value).Case(S2, Value);
  }

  /*template <unsigned int N0, unsigned int N1, unsigned int N2, unsigned int N3> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::Cases">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 97,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::Cases")
  //</editor-fold>
  public StringSwitchInt /*&*/ Cases(String S0, String S1, String S2, String S3, /*const*/int /*&*/ Value) {
    return Case(S0, Value).Case(S1, Value).Case(S2, Value).Case(S3, Value);
  }

  /*template <unsigned int N0, unsigned int N1, unsigned int N2, unsigned int N3, unsigned int N4> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::Cases">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 104,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::Cases")
  //</editor-fold>
  public StringSwitchInt /*&*/ Cases(String S0, String S1, String S2, String S3, String S4, /*const*/int /*&*/ Value) {
    return Case(S0, Value).Case(S1, Value).Case(S2, Value).Case(S3, Value).Case(S4, Value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::Default">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", old_line = 111,
   FQN = "llvm::StringSwitch::Default", NM = "_ZNK4llvm12StringSwitch7DefaultERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK4llvm12StringSwitch7DefaultERKT_")
  //</editor-fold>
  public int Default(/*const*/int /*&*/ Value) /*const*/ {
    if (hasResult) {
      return $Deref(Result);
    }
    
    return Value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringSwitch::operator type-parameter-0-1">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringSwitch.h", line = 118,
   FQN = "llvm::StringSwitch::operator type-parameter-0-1", NM = "_ZNK4llvm12StringSwitchcvT0_Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -filter=llvm::StringSwitch::operator type-parameter-0-1")
  //</editor-fold>
  public int $T_0_1() /*const*/ {
    assert (hasResult) : "Fell off the end of a string-switch";
    return $Deref(Result);
  }

}
