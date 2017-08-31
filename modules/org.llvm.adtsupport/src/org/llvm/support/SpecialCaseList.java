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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", line = 60,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", old_line = 58,
 FQN="llvm::SpecialCaseList", NM="_ZN4llvm15SpecialCaseListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseListE")
//</editor-fold>
public class SpecialCaseList implements Destructors.ClassWithDestructor {
/*public:*/
  /// Parses the special case list entries from files. On failure, returns
  /// 0 and writes an error message to string.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 49,
   FQN="llvm::SpecialCaseList::create", NM="_ZN4llvm15SpecialCaseList6createERKSt6vectorISsSaISsEERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList6createERKSt6vectorISsSaISsEERSs")
  //</editor-fold>
  public static std.unique_ptr<SpecialCaseList> create(/*const*/std.vectorString/*&*/ Paths, 
        std.string/*&*/ Error) {
    std.unique_ptr<SpecialCaseList> SCL = null;
    try {
      SCL/*J*/= new std.unique_ptr<SpecialCaseList>(new SpecialCaseList());
      for (std.string Path : Paths) {
        ErrorOr<std.unique_ptr<MemoryBuffer> > FileOrErr = null;
        try {
          FileOrErr = MemoryBuffer.getFile(new Twine(Path));
          {
            std.error_code EC = FileOrErr.getError();
            if (EC.$bool()) {
              Error.$assignMove(($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"can't open file '"), new Twine(Path)), new Twine(/*KEEP_STR*/"': ")), new Twine(EC.message()))).str());
              return new std.unique_ptr<SpecialCaseList>(JD$NullPtr.INSTANCE, null);
            }
          }
          std.string ParseError/*J*/= new std.string();
          if (!SCL.$arrow().parse(FileOrErr.get().get(), ParseError)) {
            Error.$assignMove(($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"error parsing file '"), new Twine(Path)), new Twine(/*KEEP_STR*/"': ")), new Twine(ParseError))).str());
            return new std.unique_ptr<SpecialCaseList>(JD$NullPtr.INSTANCE, null);
          }
        } finally {
          if (FileOrErr != null) { FileOrErr.$destroy(); }
        }
      }
      SCL.$arrow().compile();
      return new std.unique_ptr<SpecialCaseList>(JD$Move.INSTANCE, SCL);
    } finally {
      if (SCL != null) { SCL.$destroy(); }
    }
  }

  /// Parses the special case list from a memory buffer. On failure, returns
  /// 0 and writes an error message to string.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 70,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 64,
   FQN="llvm::SpecialCaseList::create", NM="_ZN4llvm15SpecialCaseList6createEPKNS_12MemoryBufferERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList6createEPKNS_12MemoryBufferERSs")
  //</editor-fold>
  public static std.unique_ptr<SpecialCaseList> create(/*const*/ MemoryBuffer /*P*/ MB, 
        std.string/*&*/ Error) {
    std.unique_ptr<SpecialCaseList> SCL = null;
    try {
      SCL/*J*/= new std.unique_ptr<SpecialCaseList>(new SpecialCaseList());
      if (!SCL.$arrow().parse(MB, Error)) {
        return new std.unique_ptr<SpecialCaseList>(JD$NullPtr.INSTANCE, null);
      }
      SCL.$arrow().compile();
      return new std.unique_ptr<SpecialCaseList>(JD$Move.INSTANCE, SCL);
    } finally {
      if (SCL != null) { SCL.$destroy(); }
    }
  }

  /// Parses the special case list entries from files. On failure, reports a
  /// fatal error.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::createOrDie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 79,
   FQN="llvm::SpecialCaseList::createOrDie", NM="_ZN4llvm15SpecialCaseList11createOrDieERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList11createOrDieERKSt6vectorISsSaISsEE")
  //</editor-fold>
  public static std.unique_ptr<SpecialCaseList> createOrDie(/*const*/std.vectorString/*&*/ Paths) {
    std.string Error/*J*/= new std.string();
    {
      unique_ptr<SpecialCaseList> SCL = null;
      try {
        SCL = create(Paths, Error);
        if (SCL.$bool()) {
          return new std.unique_ptr<SpecialCaseList>(JD$Move.INSTANCE, SCL);
        }
      } finally {
        if (SCL != null) { SCL.$destroy(); }
      }
    }
    report_fatal_error(Error);
    throw new llvm_unreachable(SpecialCaseList.class.getSimpleName() + ".createOrDie has died");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::~SpecialCaseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 155,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 146,
   FQN="llvm::SpecialCaseList::~SpecialCaseList", NM="_ZN4llvm15SpecialCaseListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseListD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Regexps.$destroy();
    Entries.$destroy();
    //END JDestroy
  }

  
  /// Returns true, if special case list contains a line
  /// \code
  ///   @Section:<E>=@Category
  /// \endcode
  /// and @Query satisfies a wildcard expression <E>.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::inSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 157,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 148,
   FQN="llvm::SpecialCaseList::inSection", NM="_ZNK4llvm15SpecialCaseList9inSectionENS_9StringRefES1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZNK4llvm15SpecialCaseList9inSectionENS_9StringRefES1_S1_")
  //</editor-fold>
  public boolean inSection(StringRef Section, StringRef Query) /*const*/ {
    return inSection(Section, Query, 
           new StringRef());
  }
  public boolean inSection(String Section, StringRef Query) {
    return inSection(Section, Query, new StringRef());
  }
  public boolean inSection(String Section, StringRef Query, 
           StringRef Category/*= StringRef()*/) /*const*/ {
    return inSection(new StringRef(Section), Query, Category);
  }
  public boolean inSection(StringRef Section, StringRef Query, 
           StringRef Category/*= StringRef()*/) /*const*/ {
    assert (IsCompiled) : "SpecialCaseList::compile() was not called!";
    StringMapConstIterator<StringMap<Entry> > I = Entries.find(/*NO_COPY*/Section);
    if (I.$eq(Entries.end())) {
      return false;
    }
    StringMapConstIterator<Entry> II = I.$arrow().second.find(/*NO_COPY*/Category);
    if (II.$eq(I.$arrow().second.end())) {
      return false;
    }
    
    return II.$arrow().getValue().match(/*NO_COPY*/Query);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::SpecialCaseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", old_line = 84,
   FQN="llvm::SpecialCaseList::SpecialCaseList", NM="_ZN4llvm15SpecialCaseListC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseListC1ERKS0_")
  //</editor-fold>
  private SpecialCaseList(/*const*/ SpecialCaseList /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", old_line = 85,
   FQN="llvm::SpecialCaseList::operator=", NM="_ZN4llvm15SpecialCaseListaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseListaSERKS0_")
  //</editor-fold>
  private SpecialCaseList /*&*/ $assign(/*const*/ SpecialCaseList /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  
  /// Represents a set of regular expressions.  Regular expressions which are
  /// "literal" (i.e. no regex metacharacters) are stored in Strings, while all
  /// others are represented as a single pipe-separated regex in RegEx.  The
  /// reason for doing so is efficiency; StringSet is much faster at matching
  /// literal strings than Regex.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::Entry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone*/,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 34,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SpecialCaseList.h", old_line = 87,
   FQN="llvm::SpecialCaseList::Entry", NM="_ZN4llvm15SpecialCaseList5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList5EntryE")
  //</editor-fold>
  private static class/*struct*/ Entry implements Destructors.ClassWithDestructor, NativeCloneable<Entry> {
    //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::Entry::Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 35,
     old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 37,
     FQN="llvm::SpecialCaseList::Entry::Entry", NM="_ZN4llvm15SpecialCaseList5EntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList5EntryC1Ev")
    //</editor-fold>
    public Entry() {
      /* : Strings(), RegEx()*/ 
      //START JInit
      this.Strings = new StringSet/*<MallocAllocator>*/();
      this.RegEx = new std.unique_ptr<Regex>();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::Entry::Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 36,
     old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 38,
     FQN="llvm::SpecialCaseList::Entry::Entry", NM="_ZN4llvm15SpecialCaseList5EntryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList5EntryC1EOS1_")
    //</editor-fold>
    public Entry(JD$Move _dparam, Entry /*&&*/Other) {
      /* : Strings(std::move(Other.Strings)), RegEx(std::move(Other.RegEx))*/ 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    public StringSet/*<MallocAllocator>*/ Strings;
    public std.unique_ptr<Regex> RegEx;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::Entry::match">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 42,
     old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 44,
     FQN="llvm::SpecialCaseList::Entry::match", NM="_ZNK4llvm15SpecialCaseList5Entry5matchENS_9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZNK4llvm15SpecialCaseList5Entry5matchENS_9StringRefE")
    //</editor-fold>
    public boolean match(StringRef Query) /*const*/ {
      return (Strings.count(new StringRef(Query)) != 0) || (RegEx.$bool() && RegEx.$arrow().match(/*NO_COPY*/Query));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::Entry::~Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 34,
     old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 36,
     FQN="llvm::SpecialCaseList::Entry::~Entry", NM="_ZN4llvm15SpecialCaseList5EntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList5EntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      RegEx.$destroy();
      Strings.$destroy();
      //END JDestroy
    }

    @Override
    public Entry clone() {
      assert Strings.empty() : "must clone only as empty default value";
      assert !RegEx.$bool() : "must clone only as empty default value";
      return new Entry();
    }
    
    public String toString() {
      return "" + "Strings=" + Strings // NOI18N
                + ", RegEx=" + RegEx; // NOI18N
    }
  };
  private StringMap<StringMap<Entry/*, MallocAllocator*/>/*, MallocAllocator*/> Entries;
  private StringMap<StringMap<std.string> > Regexps;
  private boolean IsCompiled;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::SpecialCaseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 47,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 49,
   FQN="llvm::SpecialCaseList::SpecialCaseList", NM="_ZN4llvm15SpecialCaseListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseListC1Ev")
  //</editor-fold>
  private SpecialCaseList() {
    /* : Entries(), Regexps(), IsCompiled(false)*/ 
    //START JInit
    this.Entries = new StringMap<StringMap<Entry/*, MallocAllocator*/>/*, MallocAllocator*/>(new StringMap(new Entry()));
    this.Regexps = new StringMap<StringMap<std.string> >(new StringMap(new std.string()));
    this.IsCompiled = false;
    //END JInit
  }

  /// Parses just-constructed SpecialCaseList entries from a memory buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 87,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", old_line = 79,
   FQN="llvm::SpecialCaseList::parse", NM="_ZN4llvm15SpecialCaseList5parseEPKNS_12MemoryBufferERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList5parseEPKNS_12MemoryBufferERSs")
  //</editor-fold>
  private boolean parse(/*const*/ MemoryBuffer /*P*/ MB, std.string/*&*/ Error) {
    // Iterate through each line in the blacklist file.
    SmallVector<StringRef> Lines/*J*/= new SmallVector<StringRef>(16, new StringRef());
    SplitString(MB.getBuffer(), Lines, new StringRef(/*KEEP_STR*/"\n\015"));
    int LineNo = 1;
    for (type$ptr<StringRef> /*P*/ I = Lines.begin(), /*P*/ E = Lines.end(); I.$noteq(E); I.$preInc() , ++LineNo) {
      Regex CheckRE = null;
      try {
        // Ignore empty lines and lines starting with "#"
        if (I.$star().empty() || I.$star().startswith(/*STRINGREF_STR*/"#")) {
          continue;
        }
        // Get our prefix and unparsed regexp.
        std.pair<StringRef, StringRef> SplitLine = I.$star().split(/*STRINGREF_STR*/":");
        StringRef Prefix = new StringRef(SplitLine.first);
        if (SplitLine.second.empty()) {
          // Missing ':' in the line.
          Error.$assignMove(($add_Twine($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"malformed line "), new Twine(JD$Int.INSTANCE, LineNo)), new Twine(/*KEEP_STR*/": '")), 
                      new Twine(SplitLine.first)), new Twine(/*KEEP_STR*/$SGL_QUOTE))).str());
          return false;
        }
        
        std.pair<StringRef, StringRef> SplitRegexp = SplitLine.second.split(/*STRINGREF_STR*/"=");
        std.string Regexp = SplitRegexp.first.$string();
        StringRef Category = new StringRef(SplitRegexp.second);
        
        // See if we can store Regexp in Strings.
        if (Regex.isLiteralERE(new StringRef(Regexp))) {
          Entries.$at(/*NO_COPY*/Prefix).$at(/*NO_COPY*/Category).Strings.insert(new StringRef(Regexp));
          continue;
        }
        
        // Replace * with .*
        for (/*size_t*/int pos = 0; (pos = Regexp.find(/*KEEP_STR*/"*", pos)) != std.string.npos;
             pos += strlen($DOT_STAR)) {
          Regexp.replace(pos, strlen($STAR), $DOT_STAR);
        }
        
        // Check that the regexp is valid.
        CheckRE/*J*/= new Regex(new StringRef(Regexp));
        std.string REError/*J*/= new std.string();
        if (!CheckRE.isValid(REError)) {
          Error.$assignMove(($add_Twine($add_Twine($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"malformed regex in line "), new Twine(JD$Int.INSTANCE, LineNo)), new Twine(/*KEEP_STR*/": '")), 
                          new Twine(SplitLine.second)), new Twine(/*KEEP_STR*/"': ")), new Twine(REError))).str());
          return false;
        }
        
        // Add this regexp into the proper group by its prefix.
        if (!Regexps.$at(/*NO_COPY*/Prefix).$at(/*NO_COPY*/Category).empty()) {
          Regexps.$at(/*NO_COPY*/Prefix).$at(/*NO_COPY*/Category).$addassign(/*KEEP_STR*/"|");
        }
        Regexps.$at(/*NO_COPY*/Prefix).$at(/*NO_COPY*/Category).$addassign($add_str_T($add_T_str$C(/*KEEP_STR*/"^", Regexp), /*KEEP_STR*/"$"));
      } finally {
        if (CheckRE != null) { CheckRE.$destroy(); }
      }
    }
    return true;
  }

  /// compile() should be called once, after parsing all the memory buffers.
  //<editor-fold defaultstate="collapsed" desc="llvm::SpecialCaseList::compile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp", line = 139,
   FQN="llvm::SpecialCaseList::compile", NM="_ZN4llvm15SpecialCaseList7compileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SpecialCaseList.cpp -nm=_ZN4llvm15SpecialCaseList7compileEv")
  //</editor-fold>
  private void compile() {
    assert (!IsCompiled) : "compile() should only be called once";
    // Iterate through each of the prefixes, and create Regexs for them.
    
    //StringMapConstIterator<StringMap<std.string> > PIZDA;
    for (StringMapIterator<StringMap<std.string> > I = new StringMapIterator<StringMap<std.string> >(JD$Move.INSTANCE, Regexps.begin()), 
        E = new StringMapIterator<StringMap<std.string> >(JD$Move.INSTANCE, Regexps.end());
         I.$noteq(E); I.$preInc()) {
      for (StringMapIterator<std.string> II = I.$arrow().second.begin(), 
          IE = I.$arrow().second.end();
           II.$noteq(IE); II.$preInc()) {
        Entries.$at(I.$arrow().getKey()).$at(II.$arrow().getKey()).RegEx.reset(new Regex(new StringRef(II.$arrow().getValue())));
      }
    }
    Regexps.clear();
    IsCompiled = true;
  }

  
  public String toString() {
    return "" + "Entries=" + Entries // NOI18N
              + ", Regexps=" + Regexps // NOI18N
              + ", IsCompiled=" + IsCompiled; // NOI18N
  }
}
