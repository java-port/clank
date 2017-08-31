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

package org.llvm.support;

import static org.clank.support.Native.$AddrOf;
import java.util.regex.Matcher;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.impl.RegexStatics.RegexMetachars;
import static org.llvm.support.impl.regcompStatics.*;
import static org.llvm.support.impl.regerrorStatics.*;
import static org.llvm.support.impl.regexecStatics.*;
import static org.llvm.support.impl.regfreeStatics.*;
import static org.llvm.support.impl.regexJava.*;

//<editor-fold defaultstate="collapsed" desc="llvm::Regex">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", line = 28,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", old_line = 29,
 FQN = "llvm::Regex", NM = "_ZN4llvm5RegexE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexE")
//</editor-fold>
public class Regex implements Destructors.ClassWithDestructor, Native.NativePOD<Regex> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", line = 30,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", old_line = 31,
   FQN = "llvm::Regex::(anonymous)", NM = "_ZN4llvm5RegexE_Unnamed_enum",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_HEX_CONSTANTS {*/
    public static final int NoFlags = 0;
    /// Compile for matching that ignores upper/lower case distinctions.
    public static final int IgnoreCase = 1;
    /// Compile for newline-sensitive matching. With this flag '[^' bracket
    /// expressions and '.' never match newline. A ^ anchor matches the
    /// null string after any newline in the string in addition to its normal
    /// function, and the $ anchor matches the null string before any
    /// newline in the string in addition to its normal function.
    public static final int Newline = 2;
    /// By default, the POSIX extended regular expression (ERE) syntax is
    /// assumed. Pass this flag to turn on basic regular expressions (BRE)
    /// instead.
    public static final int BasicRegex = 4;
  /*}*/;
  
  /// Compiles the given regular expression \p Regex.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::Regex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 22,
   FQN="llvm::Regex::Regex", NM="_ZN4llvm5RegexC1ENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexC1ENS_9StringRefEj")
  //</editor-fold>
  public Regex(StringRef regex) {
    this(regex, NoFlags);
  }
  public Regex(StringRef regex, /*uint*/int Flags/*= NoFlags*/) {
    /*uint*/int flags = 0;
    preg = new llvm_regex();
    preg.re_endp = $tryClone(regex.end());
    if (((Flags & IgnoreCase) != 0)) {
      flags |= REG_ICASE;
    }
    if (((Flags & Newline) != 0)) {
      flags |= REG_NEWLINE;
    }
    if (!((Flags & BasicRegex) != 0)) {
      flags |= REG_EXTENDED;
    }
    try {
      String s = regex.toJavaString();
      if (!s.startsWith("(^)") && !s.startsWith("^") && !s.startsWith(".*") && !s.isEmpty()) {
        s = ".*" + s;
      }
      if (!s.endsWith("($)") && !s.endsWith("$") && !s.endsWith(".*") && !s.isEmpty()) {
        s = s+".*";
      }
      this.RegExpString = java.util.regex.Pattern.compile(s);
      error = 0;
    } catch (Throwable e) {
      error = llvm_regcomp(preg, regex.data(), flags | REG_PEND);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::Regex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", old_line = 49,
   FQN = "llvm::Regex::Regex", NM = "_ZN4llvm5RegexC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexC1ERKS0_")
  //</editor-fold>
  public Regex(/*const*/ Regex /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", old_line = 50,
   FQN = "llvm::Regex::operator=", NM = "_ZN4llvm5RegexaSES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexaSES0_")
  //</editor-fold>
  public Regex /*&*/ $assign(Regex regex) {
    swap_llvm_regex(preg, regex.preg);
    std.swap(error, regex.error);
    java.util.regex.Pattern tmp = this.RegExpString;
    this.RegExpString = regex.RegExpString;
    regex.RegExpString = tmp;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::Regex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Regex.h", old_line = 55,
   FQN = "llvm::Regex::Regex", NM = "_ZN4llvm5RegexC1EOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexC1EOS0_")
  //</editor-fold>
  public Regex(JD$Move _dparam, Regex /*&&*/regex) {
    preg = regex.preg;
    error = regex.error;
    regex.preg = null;
    this.RegExpString = regex.RegExpString;
    regex.RegExpString = null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::~Regex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 35,
   FQN="llvm::Regex::~Regex", NM="_ZN4llvm5RegexD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5RegexD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((preg != null)) {
      llvm_regfree(preg);
      /*delete*/Destructors.$destroy(preg);
    }
  }

  
  /// isValid - returns the error encountered during regex compilation, or
  /// matching, if any.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::isValid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 42,
   FQN="llvm::Regex::isValid", NM="_ZN4llvm5Regex7isValidERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5Regex7isValidERSs")
  //</editor-fold>
  public boolean isValid(std.string/*&*/ Error) {
    if (!(error != 0)) {
      return true;
    }
    
    /*size_t*/int len = llvm_regerror(error, preg, null, 0);
    
    Error.resize(len - 1);
    llvm_regerror(error, preg, $AddrOf(Error.data()), len);
    return false;
  }

  
  /// getNumMatches - In a valid regex, return the number of parenthesized
  /// matches it contains.  The number filled in by match will include this
  /// many entries plus one for the whole regex (as element 0).
  
  /// getNumMatches - In a valid regex, return the number of parenthesized
  /// matches it contains.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::getNumMatches">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 55,
   FQN="llvm::Regex::getNumMatches", NM="_ZNK4llvm5Regex13getNumMatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZNK4llvm5Regex13getNumMatchesEv")
  //</editor-fold>
  public /*uint*/int getNumMatches() /*const*/ {
    return preg.re_nsub;
  }

  
  /// matches - Match the regex against a given \p String.
  ///
  /// \param Matches - If given, on a successful match this will be filled in
  /// with references to the matched group expressions (inside \p String),
  /// the first group is always the entire pattern.
  ///
  /// This returns true on a successful match.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 59,
   FQN="llvm::Regex::match", NM="_ZN4llvm5Regex5matchENS_9StringRefEPNS_15SmallVectorImplIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5Regex5matchENS_9StringRefEPNS_15SmallVectorImplIS1_EE")
  //</editor-fold>
  public boolean match(char$ptr str) {
    return match(new StringRef(str));
  }
  public boolean match(StringRef String) {
    return match(String, (SmallVectorImpl<StringRef> /*P*/ )null);
  }
  public boolean match(StringRef String, SmallVectorImpl<StringRef> /*P*/ Matches/*= null*/) {
    if (this.RegExpString != null) {
      // JAVA: use java regexp support for now
      Matcher matcher = RegExpString.matcher(String.toJavaString());
      boolean res = matcher.matches();
      if (res && Matches != null) {
        Matches.clear();
        for(int i = 0; i <= matcher.groupCount(); i++) {
          Matches.push_back(new StringRef(matcher.group(i)));
        }
      }
      return res;
    }
    SmallVector<llvm_regmatch_t> pm = null;
    try {
      /*uint*/int nmatch = (Matches != null) ? preg.re_nsub + 1 : 0;
      
      // pmatch needs to have at least one element.
      pm/*J*/= new SmallVector<llvm_regmatch_t>(8, new llvm_regmatch_t());
      pm.resize(nmatch > 0 ? nmatch : 1);
      pm.$at(0).rm_so = 0;
      pm.$at(0).rm_eo = String.size();
      
      int rc = llvm_regexec(preg, String.data(), nmatch, pm.data(), REG_STARTEND);
      if (rc == REG_NOMATCH) {
        return false;
      }
      if (rc != 0) {
        // regexec can fail due to invalid pattern or running out of memory.
        error = rc;
        return false;
      }
      
      // There was a match.
      if ((Matches != null)) { // match position requested
        Matches.clear();
        
        for (/*uint*/int i = 0; i != nmatch; ++i) {
          if (pm.$at(i).rm_so == -1L) {
            // this group didn't match
            Matches.push_back(new StringRef());
            continue;
          }
          assert (pm.$at(i).rm_eo >= pm.$at(i).rm_so);
          Matches.push_back(new StringRef(String.data().$add($long2uint(pm.$at(i).rm_so)), $long2uint(pm.$at(i).rm_eo - pm.$at(i).rm_so)));
        }
      }
      
      return true;
    } finally {
      if (pm != null) { pm.$destroy(); }
    }
  }
  public boolean find(char$ptr str) {
    return find(new StringRef(str));
  }
  public boolean find(StringRef String) {
    Matcher matcher = RegExpString.matcher(String.toJavaString());
    if (RegExpString.pattern().isEmpty()) {
      return false;
    }
    return matcher.find();
  }

  
  /// sub - Return the result of replacing the first match of the regex in
  /// \p String with the \p Repl string. Backreferences like "\0" in the
  /// replacement string are replaced with the appropriate match substring.
  ///
  /// Note that the replacement string has backslash escaping performed on
  /// it. Invalid backreferences are ignored (replaced by empty strings).
  ///
  /// \param Error If non-null, any errors in the substitution (invalid
  /// backreferences, trailing backslashes) will be recorded as a non-empty
  /// string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::sub">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 98,
   FQN="llvm::Regex::sub", NM="_ZN4llvm5Regex3subENS_9StringRefES1_PSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5Regex3subENS_9StringRefES1_PSs")
  //</editor-fold>
  public std.string sub(StringRef Repl, StringRef String) {
    return sub(Repl, String, 
     (std.string/*P*/ )null);
  }
  public std.string sub(StringRef Repl, StringRef String, 
     std.string/*P*/ Error/*= null*/) {
    SmallVector<StringRef> Matches = null;
    std.string Res = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Matches/*J*/= new SmallVector<StringRef>(8, new StringRef());
      
      // Reset error, if given.
      if ((Error != null) && !Error.empty()) {
        /*Deref*/Error.$assign($(""));
      }
      
      // Return the input if there was no match.
      if (!match(new StringRef(String), $AddrOf(Matches))) {
        return String.$string();
      }
      
      // Otherwise splice in the replacement string, starting with the prefix before
      // the match.
      Res/*J*/= new std.string(String.begin(), Matches.$at(0).begin());
      
      // Then the replacement string, honoring possible substitutions.
      while (!Repl.empty()) {
        // Skip to the next escape.
        std.pair<StringRef, StringRef> Split = Repl.split($('\\'));
        
        // Add the skipped substring.
        $addassign_str_StringRef(Res, new StringRef(Split.first));
        
        // Check for terminimation and trailing backslash.
        if (Split.second.empty()) {
          if (Repl.size() != Split.first.size()
             && (Error != null) && Error.empty()) {
            /*Deref*/Error.$assign($("replacement string contained trailing backslash"));
          }
          break;
        }
        
        // Otherwise update the replacement string and interpret escapes.
        Repl.$assign(Split.second);
        
        // FIXME: We should have a StringExtras function for mapping C99 escapes.
        switch (Repl.$at(0)) {
         default:
          // Treat all unrecognized characters as self-quoting.
          Res.$addassign(Repl.$at(0));
          Repl.$assignMove(Repl.substr(1));
          break;
         case 't':
          
          // Single character escapes.
          Res.$addassign($('\t'));
          Repl.$assignMove(Repl.substr(1));
          break;
         case 'n':
          Res.$addassign($('\n'));
          Repl.$assignMove(Repl.substr(1));
          break;
         case '0':
         case '1':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9':
          {
            // Extract the backreference number.
            StringRef Ref = Repl.slice(0, Repl.find_first_not_of(new StringRef($("0123456789"))));
            Repl.$assignMove(Repl.substr(Ref.size()));
            
            /*uint*/int$ref RefValue = create_int$ref();
            if (!Ref.getAsInteger(10, RefValue)
               && RefValue.$deref() < Matches.size()) {
              $addassign_str_StringRef(Res, new StringRef(Matches.$at(RefValue.$deref())));
            } else if ((Error != null) && Error.empty()) {
              $c$.clean(/*Deref*/Error.$assignMove($c$.track($add_str_T($c$.track($add_T_str($("invalid backreference string '"), $c$.track(Ref.str()))), $("'")))));
            }
            break;
          }
        }
      }
      
      // And finally the suffix.
      $addassign_str_StringRef(Res, new StringRef(Matches.$at(0).end(), String.end().$sub(Matches.$at(0).end())));
      
      return new std.string(JD$Move.INSTANCE, Res);
    } finally {
      if (Res != null) { Res.$destroy(); }
      if (Matches != null) { Matches.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief If this function returns true, ^Str$ is an extended regular
  /// expression that matches Str and only Str.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::isLiteralERE">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 177,
   FQN="llvm::Regex::isLiteralERE", NM="_ZN4llvm5Regex12isLiteralEREENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5Regex12isLiteralEREENS_9StringRefE")
  //</editor-fold>
  public static boolean isLiteralERE(StringRef Str) {
    // Check for regex metacharacters.  This list was derived from our regex
    // implementation in regcomp.c and double checked against the POSIX extended
    // regular expression specification.
    return Str.find_first_of(new StringRef(RegexMetachars)) == StringRef.npos;
  }

  
  /// \brief Turn String into a regex by escaping its special characters.
  //<editor-fold defaultstate="collapsed" desc="llvm::Regex::escape">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Regex.cpp", line = 184,
   FQN="llvm::Regex::escape", NM="_ZN4llvm5Regex6escapeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Regex.cpp -nm=_ZN4llvm5Regex6escapeENS_9StringRefE")
  //</editor-fold>
  public static std.string escape(StringRef String) {
    std.string RegexStr = null;
    try {
      RegexStr/*J*/= new std.string();
      for (/*uint*/int i = 0, e = String.size(); i != e; ++i) {
        if ((strchr(RegexMetachars, String.$at(i)) != null)) {
          RegexStr.$addassign($('\\'));
        }
        RegexStr.$addassign(String.$at(i));
      }
      
      return new std.string(JD$Move.INSTANCE, RegexStr);
    } finally {
      if (RegexStr != null) { RegexStr.$destroy(); }
    }
  }

/*private:*/
  private  llvm_regex /*P*/ preg;
  private  /*final*/ java.util.regex.Pattern RegExpString; // JAVA: use java regexp support for now
  private int error;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public Regex() {
    this.RegExpString = null;
  }
  
  @Override
  public Regex clone() {
    return new Regex(this);
  }

  @Override
  public boolean $eq(Regex other) {
    return other != null && other.RegExpString.equals(this.RegExpString);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "preg=" + preg // NOI18N
              + ", error=" + error; // NOI18N
  }
}
