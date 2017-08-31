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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.frontend.impl.LayoutOverrideSourceStatics.*;

/// \brief An external AST source that overrides the layout of
/// a specified set of record types.
///
/// This class is used only for testing the ability of external AST sources
/// to override the layout of record types. Its input is the output format
/// of the command-line argument -fdump-record-layouts.
//<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 25,
 FQN="clang::LayoutOverrideSource", NM="_ZN5clang20LayoutOverrideSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSourceE")
//</editor-fold>
public class LayoutOverrideSource extends /*public*/ ExternalASTSource implements Destructors.ClassWithDestructor {
  /// \brief The layout of a given record.
  //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::Layout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 27,
   FQN="clang::LayoutOverrideSource::Layout", NM="_ZN5clang20LayoutOverrideSource6LayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource6LayoutE")
  //</editor-fold>
  private static class/*struct*/ Layout implements Destructors.ClassWithDestructor {
    /// \brief The size of the record.
    public long/*uint64_t*/ Size;
    
    /// \brief The alignment of the record.
    public long/*uint64_t*/ Align;
    
    /// \brief The offsets of the fields, in source order.
    public SmallVectorULong FieldOffsets;
    //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::Layout::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 27,
     FQN="clang::LayoutOverrideSource::Layout::operator=", NM="_ZN5clang20LayoutOverrideSource6LayoutaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource6LayoutaSEOS1_")
    //</editor-fold>
    public /*inline*/ Layout /*&*/ $assignMove(Layout /*&&*/$Prm0) {
      this.Size = $Prm0.Size;
      this.Align = $Prm0.Align;
      this.FieldOffsets.$assignMove($Prm0.FieldOffsets);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::Layout::Layout">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 27,
     FQN="clang::LayoutOverrideSource::Layout::Layout", NM="_ZN5clang20LayoutOverrideSource6LayoutC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource6LayoutC1Ev")
    //</editor-fold>
    public /*inline*/ Layout() {
      // : FieldOffsets() 
      //START JInit
      this.FieldOffsets = new SmallVectorULong(8, 0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::Layout::~Layout">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 27,
     FQN="clang::LayoutOverrideSource::Layout::~Layout", NM="_ZN5clang20LayoutOverrideSource6LayoutD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource6LayoutD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      FieldOffsets.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::Layout::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 27,
     FQN="clang::LayoutOverrideSource::Layout::operator=", NM="_ZN5clang20LayoutOverrideSource6LayoutaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource6LayoutaSERKS1_")
    //</editor-fold>
    public /*inline*/ Layout /*&*/ $assign(/*const*/ Layout /*&*/ $Prm0) {
      this.Size = $Prm0.Size;
      this.Align = $Prm0.Align;
      this.FieldOffsets.$assign($Prm0.FieldOffsets);
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Size=" + Size // NOI18N
                + ", Align=" + Align // NOI18N
                + ", FieldOffsets=" + FieldOffsets; // NOI18N
    }
  };
  
  /// \brief The set of layouts that will be overridden.
  private StringMap<Layout/*, MallocAllocator*/> Layouts;
/*public:*/
  /// \brief Create a new AST source that overrides the layout of some
  /// set of record types.
  ///
  /// The file is the result of passing -fdump-record-layouts to a file.
  //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::LayoutOverrideSource">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp", line = 30,
   FQN="clang::LayoutOverrideSource::LayoutOverrideSource", NM="_ZN5clang20LayoutOverrideSourceC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSourceC1EN4llvm9StringRefE")
  //</editor-fold>
  public LayoutOverrideSource(StringRef Filename) {
    // : ExternalASTSource(), Layouts() 
    //START JInit
    super();
    this.Layouts = new StringMap<Layout/*, MallocAllocator*/>(new Layout());
    //END JInit
    basic_ifstream/*<char>*/ Input = null;
    Layout CurrentLayout = null;
    try {
      Input/*J*/= new basic_ifstream/*<char>*/(Filename.str().c_str());
      if (!Input.is_open()) {
        return;
      }
      
      // Parse the output of -fdump-record-layouts.
      std.string CurrentType/*J*/= new std.string();
      CurrentLayout/*J*/= new Layout();
      boolean ExpectingType = false;
      while (Input.good()) {
        std.string Line/*J*/= new std.string();
        getline_is_string(Input, Line);
        
        StringRef LineStr/*J*/= new StringRef(Line);
        
        // Determine whether the following line will start a 
        if (LineStr.find(/*STRINGREF_STR*/"*** Dumping AST Record Layout") != StringRef.npos) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Flush the last type/layout, if there is one.
            if (!CurrentType.empty()) {
              Layouts.$at(new StringRef(CurrentType)).$assign(CurrentLayout);
            }
            $c$.clean(CurrentLayout.$assignMove($c$.track(new Layout())));
            
            ExpectingType = true;
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // If we're expecting a type, grab it.
        if (ExpectingType) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            ExpectingType = false;
            
            /*size_t*/int Pos;
            if ((Pos = LineStr.find(/*STRINGREF_STR*/"struct ")) != StringRef.npos) {
              LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"struct ")));
            } else if ((Pos = LineStr.find(/*STRINGREF_STR*/"class ")) != StringRef.npos) {
              LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"class ")));
            } else if ((Pos = LineStr.find(/*STRINGREF_STR*/"union ")) != StringRef.npos) {
              LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"union ")));
            } else {
              continue;
            }
            
            // Find the name of the type.
            CurrentType.$assignMove(parseName(new StringRef(LineStr)));
            $c$.clean(CurrentLayout.$assignMove($c$.track(new Layout())));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Check for the size of the type.
        /*size_t*/int Pos = LineStr.find(/*STRINGREF_STR*/" Size:");
        if (Pos != StringRef.npos) {
          // Skip past the " Size:" prefix.
          LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/" Size:")));
          
          /*ullong*/ullong$ref Size = create_ullong$ref(0);
          /*(void)*/LineStr.getAsInteger$NotSigned(10, Size);
          CurrentLayout.Size = Size.$deref();
          continue;
        }
        
        // Check for the alignment of the type.
        Pos = LineStr.find(/*STRINGREF_STR*/"Alignment:");
        if (Pos != StringRef.npos) {
          // Skip past the "Alignment:" prefix.
          LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"Alignment:")));
          
          /*ullong*/ullong$ref Alignment = create_ullong$ref(0);
          /*(void)*/LineStr.getAsInteger$NotSigned(10, Alignment);
          CurrentLayout.Align = Alignment.$deref();
          continue;
        }
        
        // Check for the size/alignment of the type.
        Pos = LineStr.find(/*STRINGREF_STR*/"sizeof=");
        if (Pos != StringRef.npos) {
          /* Skip past the sizeof= prefix. */
          LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"sizeof=")));
          
          // Parse size.
          /*ullong*/ullong$ref Size = create_ullong$ref(0);
          /*(void)*/LineStr.getAsInteger$NotSigned(10, Size);
          CurrentLayout.Size = Size.$deref();
          
          Pos = LineStr.find(/*STRINGREF_STR*/"align=");
          if (Pos != StringRef.npos) {
            /* Skip past the align= prefix. */
            LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"align=")));
            
            // Parse alignment.
            /*ullong*/ullong$ref Alignment = create_ullong$ref(0);
            /*(void)*/LineStr.getAsInteger$NotSigned(10, Alignment);
            CurrentLayout.Align = Alignment.$deref();
          }
          
          continue;
        }
        
        // Check for the field offsets of the type.
        Pos = LineStr.find(/*STRINGREF_STR*/"FieldOffsets: [");
        if (Pos == StringRef.npos) {
          continue;
        }
        
        LineStr.$assignMove(LineStr.substr(Pos + strlen(/*KEEP_STR*/"FieldOffsets: [")));
        while (!LineStr.empty() && isDigit(LineStr.$at(0))) {
          // Parse this offset.
          /*uint*/int Idx = 1;
          while ($less_uint(Idx, LineStr.size()) && isDigit(LineStr.$at(Idx))) {
            ++Idx;
          }
          
          /*ullong*/ullong$ref Offset = create_ullong$ref(0);
          /*(void)*/LineStr.substr(0, Idx).getAsInteger$NotSigned(10, Offset);
          
          CurrentLayout.FieldOffsets.push_back(Offset.$deref());
          
          // Skip over this offset, the following comma, and any spaces.
          LineStr.$assignMove(LineStr.substr(Idx + 1));
          while (!LineStr.empty() && isWhitespace(LineStr.$at(0))) {
            LineStr.$assignMove(LineStr.substr(1));
          }
        }
      }
      
      // Flush the last type/layout, if there is one.
      if (!CurrentType.empty()) {
        Layouts.$at(new StringRef(CurrentType)).$assign(CurrentLayout);
      }
    } finally {
      if (CurrentLayout != null) { CurrentLayout.$destroy(); }
      if (Input != null) { Input.$destroy(); }
    }
  }

  
  /// \brief If this particular record type has an overridden layout,
  /// return that layout.
  //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::layoutRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp", line = 155,
   FQN="clang::LayoutOverrideSource::layoutRecordType", NM="_ZN5clang20LayoutOverrideSource16layoutRecordTypeEPKNS_10RecordDeclERyS4_RN4llvm8DenseMapIPKNS_9FieldDeclEyNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_yEEEERNS6_IPKNS_13CXXRecordDeclENS_9CharUnitsENSA_ISJ_EENSD_ISJ_SK_EEEESO_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource16layoutRecordTypeEPKNS_10RecordDeclERyS4_RN4llvm8DenseMapIPKNS_9FieldDeclEyNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_yEEEERNS6_IPKNS_13CXXRecordDeclENS_9CharUnitsENSA_ISJ_EENSD_ISJ_SK_EEEESO_")
  //</editor-fold>
  @Override public boolean layoutRecordType(/*const*/ RecordDecl /*P*/ Record, 
                  ulong$ref/*uint64_t &*/ Size, ulong$ref/*uint64_t &*/ Alignment, 
                  DenseMapTypeULong</*const*/ FieldDecl /*P*/>/*&*/ FieldOffsets, 
                  DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ BaseOffsets, 
                  DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ VirtualBaseOffsets)/* override*/ {
    // We can't override unnamed declarations.
    if (!(Record.getIdentifier() != null)) {
      return false;
    }
    
    // Check whether we have a layout for this record.
    StringMapIterator<Layout> Known = Layouts.find(Record.getName());
    if (Known.$eq(Layouts.end())) {
      return false;
    }
    
    // Provide field layouts.
    /*uint*/int NumFields = 0;
    for (specific_decl_iterator<FieldDecl> F = Record.field_begin(), 
        FEnd = Record.field_end();
         $noteq_specific_decl_iterator$SpecificDecl$C(F, FEnd); F.$preInc() , ++NumFields) {
      if ($greatereq_uint(NumFields, Known.$arrow().second.FieldOffsets.size())) {
        continue;
      }
      
      FieldOffsets.$set(F.$star(), Known.$arrow().second.FieldOffsets.$at(NumFields));
    }
    
    // Wrong number of fields.
    if (NumFields != Known.$arrow().second.FieldOffsets.size()) {
      return false;
    }
    
    Size.$set(Known.$arrow().second.Size);
    Alignment.$set(Known.$arrow().second.Align);
    return true;
  }

  
  /// \brief Dump the overridden layouts.
  //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp", line = 191,
   FQN="clang::LayoutOverrideSource::dump", NM="_ZN5clang20LayoutOverrideSource4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSource4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    raw_ostream /*&*/ OS = llvm.errs();
    for (StringMapIterator<Layout> L = Layouts.begin(), 
        LEnd = Layouts.end();
         L.$noteq(LEnd); L.$preInc()) {
      OS.$out(/*KEEP_STR*/"Type: blah ").$out(L.$arrow().first()).$out_char($$LF);
      OS.$out(/*KEEP_STR*/"  Size:").$out_ullong(L.$arrow().second.Size).$out_char($$LF);
      OS.$out(/*KEEP_STR*/"  Alignment:").$out_ullong(L.$arrow().second.Align).$out_char($$LF);
      OS.$out(/*KEEP_STR*/"  FieldOffsets: [");
      for (/*uint*/int I = 0, N = L.$arrow().second.FieldOffsets.size(); I != N; ++I) {
        if ((I != 0)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        OS.$out_ullong(L.$arrow().second.FieldOffsets.$at(I));
      }
      OS.$out(/*KEEP_STR*/"]\n");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LayoutOverrideSource::~LayoutOverrideSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LayoutOverrideSource.h", line = 25,
   FQN="clang::LayoutOverrideSource::~LayoutOverrideSource", NM="_ZN5clang20LayoutOverrideSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LayoutOverrideSource.cpp -nm=_ZN5clang20LayoutOverrideSourceD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Layouts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Layouts=" + Layouts // NOI18N
              + super.toString(); // NOI18N
  }
}
