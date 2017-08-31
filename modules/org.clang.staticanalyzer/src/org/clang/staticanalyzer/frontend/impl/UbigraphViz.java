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

package org.clang.staticanalyzer.frontend.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.sys;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UbigraphViz">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 722,
 FQN="(anonymous namespace)::UbigraphViz", NM="_ZN12_GLOBAL__N_111UbigraphVizE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_111UbigraphVizE")
//</editor-fold>
public class UbigraphViz extends /*public*/ ExplodedNode.Auditor implements Destructors.ClassWithDestructor {
  private std.unique_ptr<raw_ostream> Out;
  private std.string Filename;
  private /*uint*/int Cntr;
  
  /*typedef llvm::DenseMap<void *, unsigned int> VMap*/
//  public final class VMap extends DenseMapTypeUInt</*const*/Object/*void P*/>{ };
  private DenseMapTypeUInt</*const*/Object/*void P*/> M;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UbigraphViz::UbigraphViz">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 785,
   FQN="(anonymous namespace)::UbigraphViz::UbigraphViz", NM="_ZN12_GLOBAL__N_111UbigraphVizC1ESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EENS2_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_111UbigraphVizC1ESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EENS2_9StringRefE")
  //</editor-fold>
  public UbigraphViz(std.unique_ptr<?extends raw_ostream> OutStream, 
      StringRef Filename) {
    // : ExplodedNode::Auditor(), Out(std::move(OutStream)), Filename(Filename.operator basic_string()), Cntr(0), M() 
    //START JInit
    super();
    this.Out = new std.unique_ptr<raw_ostream>(JD$Move.INSTANCE, std.move(OutStream));
    this.Filename = Filename.$string();
    this.Cntr = 0;
    this.M = new DenseMapTypeUInt</*const*/Object/*void P*/>(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
    
    Out.$star().$out(/*KEEP_STR*/"('vertex_style_attribute', 0, ('shape', 'icosahedron'))\n");
    Out.$star().$out(/*KEEP_STR*/"('vertex_style', 1, 0, ('shape', 'sphere'), ('color', '#ffcc66'), ('size', '1.5'))\n");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UbigraphViz::~UbigraphViz">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 794,
   FQN="(anonymous namespace)::UbigraphViz::~UbigraphViz", NM="_ZN12_GLOBAL__N_111UbigraphVizD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_111UbigraphVizD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    Out.reset();
    llvm.errs().$out(/*KEEP_STR*/"Running 'ubiviz' program... ");
    std.string ErrMsg/*J*/= new std.string();
    std.string Ubiviz/*J*/= new std.string();
    {
      ErrorOr<std.string> Path = sys.findProgramByName(new StringRef(/*KEEP_STR*/"ubiviz"));
      if (Path.$bool()) {
        Ubiviz.$assign(Path.$star());
      }
    }
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {Ubiviz.c_str(), Filename.c_str(), null});
    if ((sys.ExecuteAndWait(new StringRef(Ubiviz), args/*.$set$addr(0)*/, (/*const*/type$ptr<char$ptr>/*char PP*/ )null, (type$ptr</*const*/ StringRef /*P*/ /*P*/>)null, 0, 0, 
        $AddrOf(ErrMsg)) != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"Error viewing graph: ").$out(ErrMsg).$out(/*KEEP_STR*/$LF);
    }
    
    // Delete the file.
    fs.remove(new Twine(Filename));
    //START JDestroy
    M.$destroy();
    Filename.$destroy();
    Out.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UbigraphViz::AddEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 751,
   FQN="(anonymous namespace)::UbigraphViz::AddEdge", NM="_ZN12_GLOBAL__N_111UbigraphViz7AddEdgeEPN5clang4ento12ExplodedNodeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_111UbigraphViz7AddEdgeEPN5clang4ento12ExplodedNodeES4_")
  //</editor-fold>
  @Override public void AddEdge(ExplodedNode /*P*/ Src, ExplodedNode /*P*/ Dst)/* override*/ {
    assert (Src != Dst) : "Self-edges are not allowed.";
    
    // Lookup the Src.  If it is a new node, it's a root.
    DenseMapIteratorTypeUInt<Object/*void P*/ /*P*/> SrcI = M.find(Src);
    /*uint*/int SrcID;
    if (SrcI.$eq(/*NO_ITER_COPY*/M.end())) {
      M.$set(Src, SrcID = Cntr++);
      Out.$star().$out(/*KEEP_STR*/"('vertex', ").$out_uint(SrcID).$out(/*KEEP_STR*/", ('color','#00ff00'))\n");
    } else {
      SrcID = SrcI.$arrow().second;
    }
    
    // Lookup the Dst.
    DenseMapIteratorTypeUInt<Object/*void P*/ /*P*/> DstI = M.find(Dst);
    /*uint*/int DstID;
    if (DstI.$eq(/*NO_ITER_COPY*/M.end())) {
      M.$set(Dst, DstID = Cntr++);
      Out.$star().$out(/*KEEP_STR*/"('vertex', ").$out_uint(DstID).$out(/*KEEP_STR*/")\n");
    } else {
      // We have hit DstID before.  Change its style to reflect a cache hit.
      DstID = DstI.$arrow().second;
      Out.$star().$out(/*KEEP_STR*/"('change_vertex_style', ").$out_uint(DstID).$out(/*KEEP_STR*/", 1)\n");
    }
    
    // Add the edge.
    Out.$star().$out(/*KEEP_STR*/"('edge', ").$out_uint(SrcID).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(DstID).$out(
        /*KEEP_STR*/", ('arrow','true'), ('oriented', 'true'))\n"
    );
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", Filename=" + Filename // NOI18N
              + ", Cntr=" + Cntr // NOI18N
              + ", M=" + M // NOI18N
              + super.toString(); // NOI18N
  }
}
